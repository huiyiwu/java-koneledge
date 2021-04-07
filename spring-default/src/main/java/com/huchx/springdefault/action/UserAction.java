package com.huchx.springdefault.action;

import com.huchx.springdefault.entity.UserEntity;
import com.huchx.springdefault.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserAction {
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public UserEntity getUserById(){
        return  userService.getUserById();
    }
}
