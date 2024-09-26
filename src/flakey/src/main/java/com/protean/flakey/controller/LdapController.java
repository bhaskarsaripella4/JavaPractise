package com.protean.flakey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LdapController {


    @GetMapping("/")
    public String index(){return ("<h1>Welcome LDAP Authenticated User</h1>");}

}
