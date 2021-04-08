package com.huchx.jpa.service;

import com.huchx.jpa.dao.primary.UserPrimaryDao;
import com.huchx.jpa.dao.second.UserSecondDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
//    @Autowired
//    UserDao userDao;
    @Autowired
    UserPrimaryDao userPrimaryDao;
    @Autowired
    UserSecondDao userSecondDao;

//    public UserEntity getUserById(int id) {
//        return userDao.getOne(id);
//    }
//
//    public UserEntity addUser(String name, int age) {
//        return userDao.saveAndFlush(new UserEntity(name, age));
//    }

    public List<Object> getAllUser() {
        List<Object> list = new ArrayList<>();
        list.addAll(userPrimaryDao.findAll());
        list.addAll(userSecondDao.findAll());
        return list;
    }
}
