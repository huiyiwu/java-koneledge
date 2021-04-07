package com.huchx.springdefault;


import com.huchx.springdefault.action.UserAction;
import com.huchx.springdefault.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        //Set注入值
        UserAction userAction = (UserAction) context.getBean("userAction");
        UserEntity userEntity = userAction.getUserById();
        System.out.println(userEntity.getName());

        //P命名空间注入值
        UserAction userAction1 = (UserAction) context.getBean("userAction2");
        UserEntity userEntity1 = userAction1.getUserById();
        System.out.println(userEntity1.getName());


    }

}
