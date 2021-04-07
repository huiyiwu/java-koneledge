package com.huchx.springdefault.action;

import com.huchx.springdefault.entity.UserEntity;
import com.huchx.springdefault.service.AccountService;
import com.huchx.springdefault.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AccountAction {
    @Resource
    AccountService accountService;

   public UserEntity getUserById(){
        return  accountService.getUserById();
    }

}
