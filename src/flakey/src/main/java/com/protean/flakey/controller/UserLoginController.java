package com.protean.flakey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class UserLoginController {

//    @GetMapping("/")
//    public String login(){
//        return ("<h1>Welcome</h1>");
//    }

    @GetMapping("/admin")
    public String adminLogin(){
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/user")
    public String userLogin(){
        return ("<h1>Welcome User</h1>");
    }



}
