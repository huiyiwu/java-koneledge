package com.huchx.springdefault;


import com.huchx.springdefault.action.AccountAction;
import com.huchx.springdefault.entity.UserEntity;
import com.huchx.springdefault.service.AccountService;
import com.huchx.springdefault.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");

        //注解
        AccountService accountService = (AccountService) context.getBean("accountService");
        UserEntity userEntity = accountService.getUserById();
        System.out.println(userEntity.getName());

    }

}
