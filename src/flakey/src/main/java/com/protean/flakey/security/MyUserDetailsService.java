package com.protean.flakey.security;

import com.protean.flakey.dto.User;
import com.protean.flakey.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUserName(userName);
        // take user object out of optional and pass to MyUserDetails constructor using user.get() and map.

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ userName));

        return user.map(MyUserDetails::new).get();
    }
}
