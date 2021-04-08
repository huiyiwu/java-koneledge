package com.huchx.jdbctemplate.controller;

import com.huchx.jdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/addUser")
    public String addUser(){
        userService.addUser();
        return "success";
    }
}
