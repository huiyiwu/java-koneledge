package com.huchx.mybatis;

import java.sql.*;

/**
 * @#{} 在预处理时，会把参数部分用一个占位符 ? 代替
 * @${} 则只是简单的字符串替换.表名用参数传递进来的时候，只能使用 ${}
 * 优先使用 #{}。因为 ${} 会导致 sql 注入的问题。
 */
public class SqlInjectDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userNmae = "yushengjun-1";
//        String userNmae = "username='  OR 1=1 -- "; //注入实例，解析为1=1恒成立
        String password = "12345";

        //平常使用
//        String sql = "Select id,username from user_table where "+"username='"+ userNmae+"'and "+"password='"+password+"'";
        //使用预编译解决SQL注入问题
        String sql = "Select id,username from user_table where username=? and password=?";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowledge","root","123456");
        PreparedStatement statement = con.prepareStatement(sql);

        //预编译sql使用
        statement.setString(1,userNmae);
        statement.setString(2,password);

        System.out.println(statement.toString());
        ResultSet resultSet= statement.executeQuery();
        while (resultSet.next()){
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            System.out.println("id:"+id+"----name:"+name);
        }
    }
}
