package com.huchx.design.pattern.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是代理，开始带你买房啦.......");
        Object ob = methodProxy.invokeSuper(o,objects);
        System.out.println("我是代理，带你你买房结束啦.......");
        return ob;
    }
}
