package com.huchx.springdefault.service;

import com.huchx.springdefault.dao.AccountDao;
import com.huchx.springdefault.dao.UserDao;
import com.huchx.springdefault.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;

@Service
public class AccountService {
    @Resource
    AccountDao accountDao;

    public UserEntity getUserById() {
       return accountDao.getUserById();
    }

}
