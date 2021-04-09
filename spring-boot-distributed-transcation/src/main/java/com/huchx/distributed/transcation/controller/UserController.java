package com.huchx.distributed.transcation.controller;

import com.huchx.distributed.transcation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


//    @RequestMapping("/getUserById")
//    public UserEntity getUserById(){
//        return  userService.getUserById(1);
//    }
    @RequestMapping("/addUser")
    public String addUser(){
        return userService.addUser("wang"+System.currentTimeMillis(),12);
    }

    @RequestMapping("/getAllUser")
    public List<Object> getAllUser(){
        return  userService.getAllUser();
    }

}
