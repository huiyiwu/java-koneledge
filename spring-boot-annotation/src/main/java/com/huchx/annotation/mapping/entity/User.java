package com.huchx.annotation.mapping.entity;

import com.huchx.annotation.mapping.SetProperty;
import com.huchx.annotation.mapping.SetTable;

@SetTable(value = "m_user")
public class User {

    @SetProperty(name = "user_id",leng = 10)
    private String userId;

    @SetProperty(name = "user_name",leng = 10)
    private String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
