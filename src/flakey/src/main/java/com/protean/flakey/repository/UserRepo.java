package com.protean.flakey.repository;

import com.protean.flakey.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    default Optional<User> findByUserName(String userName){ //defender methods or virtual extension methods using default keyword. provides backward compatibility
        return null;
    }


}
