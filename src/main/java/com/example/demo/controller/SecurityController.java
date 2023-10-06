package com.example.demo.controller;

import com.example.demo.services.UserDetailsServiceImpl;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
}