package com.huchx.helloword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//第二种启动方式
//@ComponentScan(basePackages = "com.huchx.helloword.controller")
//@EnableAutoConfiguration

//第三种启动方式，包含第二种方式中得注解
@SpringBootApplication
public class HellowordApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellowordApplication.class, args);
    }

}
