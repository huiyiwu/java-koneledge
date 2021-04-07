package com.huchx.springdefault;


import com.huchx.springdefault.action.UserAction;
import com.huchx.springdefault.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest1 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       //创建实例
        UserEntity userEntity = (UserEntity) context.getBean("userEntity");
        System.out.println(userEntity.getName());

        UserEntity user1 = (UserEntity) context.getBean("user1");
        System.out.println(user1.getName());


        UserEntity user2 = (UserEntity) context.getBean("user2");
        System.out.println(user2.getName());


        UserEntity user3 = (UserEntity) context.getBean("user3");
        System.out.println(user3.getName());


        UserEntity user4 = (UserEntity) context.getBean("user4");
        System.out.println(user4.getName());
    }

}
