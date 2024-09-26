package com.protean.flakey.security;

import com.protean.flakey.dto.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails{

    private String username;
    private String password;
    private Boolean active;
    private List<GrantedAuthority> authority;
//
//    public MyUserDetails(String userName){
//        this.username = userName;
//    }

    public MyUserDetails(User  user){
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.active = user.getActive();
        this.authority = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public MyUserDetails(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        return authority;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return active;
    }


}
