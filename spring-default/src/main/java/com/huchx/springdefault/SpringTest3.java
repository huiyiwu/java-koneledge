package com.huchx.springdefault;


import com.huchx.springdefault.action.AccountAction;
import com.huchx.springdefault.action.UserAction;
import com.huchx.springdefault.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class SpringTest3 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        //注解
        AccountAction accountAction = (AccountAction) context.getBean("accountAction");
        UserEntity userEntity = accountAction.getUserById();
        System.out.println(userEntity.getName());

    }

}
