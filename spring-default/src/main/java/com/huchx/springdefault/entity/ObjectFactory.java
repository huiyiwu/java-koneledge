package com.huchx.springdefault.entity;

public class ObjectFactory {
    public static UserEntity newInstance() {
        
       UserEntity userEntity = new UserEntity("huchx3",28);
       return userEntity;
    }
    public UserEntity getInstance(){
        UserEntity userEntity = new UserEntity("huchx4",29);
        return userEntity;
    }
}
