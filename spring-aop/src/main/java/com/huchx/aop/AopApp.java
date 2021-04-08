package com.huchx.aop;

import com.huchx.aop.action.UserAction;
import com.huchx.aop.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AopApp
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserAction action = (UserAction) context.getBean("userAction");
       UserEntity userEntity =  action.getUser();
        System.out.println(userEntity);
    }
}
