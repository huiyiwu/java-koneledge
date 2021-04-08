package com.huchx.mybatis.service;

import com.huchx.mybatis.entity.UserEntity;
import com.huchx.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserEntity getUserById(int id){
        return  userMapper.getUserById(id);
    }

    public int addUser(String name,int age){
        return userMapper.addUser(name,age);
    }
}
