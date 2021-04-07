package com.huchx.mybatis;

import com.huchx.mybatis.entity.User;
import com.huchx.mybatis.entity.UserTable;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * 因为在数据库中间，数据库语言分为两类
 * 一类为DML（数据操作语言）
 * 增 INSERT 删DELETE 改UPDATE
 * 一类为DDL（数据定义语言）
 * 创建表（create table ） 修改表（alter table） 删除表 （ drop table）等等（除了增删改的语句）
 * 在DDL语句里面自带了commit（）事务的提交，而DMl语句里面未带，当DML完成操作后，并不会被数据库接收到，所以数据库认为未写common（）；DML进行的数据变更为“脏数据”，写不进去数据库。
 */
public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //获取会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        //查询
//        selectUser(session);

        //添加
//        addUser(session);

        //删除
//        delUser(session);

        //测试Sql注入
//        sqlInject(session);

        //使用注解查询
        getUserTable(session);

    }

    /**
     * 使用注解查询
     * @select
     * @delete
     * @update
     *
     * @param session
     */
    private static void getUserTable(SqlSession session) {
        //查询
        String sql = "com.huchx.mybatis.mapper.UserTableMapper.getUserTable";
        //调用API语句
        UserTable userTable = session.selectOne(sql,1);
        System.out.println(userTable.getUserName());
    }

    /**
     * 测试SQL注入
     * 优先使用 #{}。因为 ${} 会导致 sql 注入的问题
     * @param session
     */
    private static void sqlInject(SqlSession session) {
        String sql = "com.huchx.mybatis.mapper.UserTableMapper.login";

        UserTable userTable = new UserTable();
        userTable.setUserName("'' OR 1=1 -- ");
        userTable.setPassword("123456");
        List<UserTable> userTables = session.selectList(sql,userTable);
        for (UserTable userTable1: userTables){
            System.out.println(userTable1.getUserName());
        }
    }

    /**
     * 删除
     * @param session
     */
    private static void delUser(SqlSession session) {
        String sql = "com.huchx.mybatis.mapper.UserMapper.delUser";

        int result = session.delete(sql,6);
        System.out.println(result);
        session.commit();
        session.close();
    }

    /**
     * 插入
     * @param session
     */
    private static void addUser(SqlSession session) {
        String sql = "com.huchx.mybatis.mapper.UserMapper.addUser";
        User user = new User();
        user.setName("huchx");
        user.setAge(27);
        int result = session.insert(sql,user);
        System.out.println(result);
        session.commit();
        session.close();
    }

    /**
     * 查询
     * @param session
     */
    private static void selectUser(SqlSession session) {
        //查询
        String sql = "com.huchx.mybatis.mapper.UserMapper.getUser";
        //调用API语句
        User user = session.selectOne(sql,1);
        System.out.println(user.getName());
    }
}
