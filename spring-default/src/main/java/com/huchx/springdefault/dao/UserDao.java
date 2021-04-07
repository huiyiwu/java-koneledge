package com.huchx.springdefault.dao;

import com.huchx.springdefault.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
     public UserEntity getUserById(){
         UserEntity userEntity = new UserEntity("userDao",12);
         return  userEntity;
     };
}
