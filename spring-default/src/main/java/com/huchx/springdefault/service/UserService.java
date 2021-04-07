package com.huchx.springdefault.service;

import com.huchx.springdefault.dao.UserDao;
import com.huchx.springdefault.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserEntity getUserById() {
       return userDao.getUserById();
    }
}
