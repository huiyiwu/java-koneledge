package com.huchx.transcation;

import com.huchx.transcation.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-trans.xml");

        UserService service = (UserService) context.getBean("userService");

        service.add();
    }
}
