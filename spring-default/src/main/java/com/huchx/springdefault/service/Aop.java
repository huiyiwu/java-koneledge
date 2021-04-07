package com.huchx.springdefault.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class Aop {
//    @Before("execution(* com.huchx.springdefault.service.AccountService.getUserById(..))")
    public void begin() {
        System.out.println("前置通知");
    }

//    @After("execution(* com.huchx.springdefault.service.AccountService.getUserById(..))")
    public void commit() {
        System.out.println("后置通知");
    }

//    @AfterReturning("execution(* com.huchx.springdefault.service.AccountService.getUserById(..))")
    public void afterReturning() {
        System.out.println("运行通知");
    }

//    @AfterThrowing("execution(* com.huchx.springdefault.service.AccountService.getUserById(..))")
    public void afterThrowing() {
        System.out.println("异常通知");
    }

//    @Around("execution(* com.huchx.springdefault.service.AccountService.getUserById(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我是环绕通知-前");
        proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知-后");
    }
}
