package com.huchx.mybatis.controller;

import com.huchx.mybatis.entity.UserEntity;
import com.huchx.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/getUserById")
    public UserEntity getUserById(){
        return  userService.getUserById(1);
    }

    @RequestMapping("/addUser")
    public int addUser(){
        return userService.addUser("huchx"+System.currentTimeMillis(),12);
    }
}
