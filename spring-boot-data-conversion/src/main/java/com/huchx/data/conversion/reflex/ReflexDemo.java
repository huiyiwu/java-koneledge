package com.huchx.data.conversion.reflex;

import com.huchx.data.conversion.reflex.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReflexDemo {
    public static void main(String[] args) {
        simpleRead();
    }

    /**
     * 读物xml配置文件中的bean。
     */
    private static void simpleRead() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) classPathXmlApplicationContext.getBean("user1");
        System.out.println("姓名："+user.getName()+"---性别："+user.getSex());
    }
}
