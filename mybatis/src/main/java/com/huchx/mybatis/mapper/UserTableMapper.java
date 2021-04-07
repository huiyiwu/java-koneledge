package com.huchx.mybatis.mapper;

import com.huchx.mybatis.entity.User;
import com.huchx.mybatis.entity.UserTable;
import org.apache.ibatis.annotations.Select;

public interface UserTableMapper {
    public UserTable login(UserTable userTable);

    @Select("select * from user_table where id= #{id}")
    public UserTable getUserTable(int id);
}
