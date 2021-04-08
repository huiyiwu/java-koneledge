package com.huchx.helloword.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration
public class HelloWorldController {
    @RequestMapping("/")
    public String hello(){
//        int i = 10/0; //发生异常
        return "hello world!";
    }

    //第一种启动方式，需要加@EnableAutoConfiguration注解
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class,args);
    }
}
