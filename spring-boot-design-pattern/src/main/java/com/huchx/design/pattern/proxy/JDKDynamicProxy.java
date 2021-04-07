package com.huchx.design.pattern.proxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @DK动态代理
 * 不需要手动生成代理类
 */
public class JDKDynamicProxy implements InvocationHandler {
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理，开始带你买房啦.......");
        Object ob = method.invoke(target,args);
        System.out.println("我是代理，带你你买房结束啦.......");
        return ob;
    }
}
