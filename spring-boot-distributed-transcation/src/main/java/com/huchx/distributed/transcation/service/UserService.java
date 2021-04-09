package com.huchx.distributed.transcation.service;

import com.huchx.distributed.transcation.dao.primary.UserPrimaryDao;
import com.huchx.distributed.transcation.dao.second.UserSecondDao;
import com.huchx.distributed.transcation.entity.primary.UserPrimaryEntity;
import com.huchx.distributed.transcation.entity.second.UserSecondEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public String addUser(String name, int age) {
        userPrimaryDao.saveAndFlush(new UserPrimaryEntity(name, age));
//        int i =10/0;
        userSecondDao.saveAndFlush(new UserSecondEntity(name, age));
        return "success";
    }

    public List<Object> getAllUser() {
        List<Object> list = new ArrayList<>();
        list.addAll(userPrimaryDao.findAll());
        list.addAll(userSecondDao.findAll());
        return list;
    }
}
