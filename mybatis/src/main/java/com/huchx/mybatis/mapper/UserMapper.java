package com.huchx.mybatis.mapper;

import com.huchx.mybatis.entity.User;

public interface UserMapper {
    public User getUser(int id);

    public void addUser(User user);

    public void delUser(int id);
}
