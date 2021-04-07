package com.huchx.springdefault.dao;

import com.huchx.springdefault.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {
     public UserEntity getUserById(){
         System.out.println("AccountDao getUserById");
         UserEntity userEntity = new UserEntity("userDao",12);
         return  userEntity;
     };
}
