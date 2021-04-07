package com.huchx.design.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @代理应用场景
 * @安全代理 可以屏蔽真实角色
 * @远程代理 远程调用代理类RMI
 * @延迟加载 先加载轻量级代理类, 真正需要在加载真实
 * @代理的分类
 * @静态代理(静态定义代理类)
 * @动态代理(动态生成代理类) -Jdk自带动态代理
 * -Cglib/javaassist（字节码操作库）
 */
public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("================静态代理===============");
        StaticProxy staticProxy = new StaticProxy(new People());
        staticProxy.buy();
        System.out.println();

        //JDK动态代理和Cglib动态代理区别
        //jdk动态代理是由Java内部的反射机制来实现的，cglib动态代理底层则是借助asm来实现的。
        // 总的来说，反射机制在生成类的过程中比较高效，而asm在生成类之后的相关执行过程中比较高效（可以通过将asm生成的类进行缓存，这样解决asm生成类过程低效问题）。
        // 还有一点必须注意：jdk动态代理的应用前提，必须是目标类基于统一的接口。如果没有上述前提，jdk动态代理不能应用。
        //注:asm其实就是java字节码控制.
        System.out.println("================JDK动态代理===============");
        People people = new People();
        JDKDynamicProxy proxy = new JDKDynamicProxy(people);
        House house = (House) Proxy.newProxyInstance(people.getClass().getClassLoader(), people.getClass().getInterfaces(), proxy);
        house.buy();
        System.out.println();
        System.out.println("================Cglib动态代理===============");
        CglibDynamicProxy proxy1 = new CglibDynamicProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(People.class);
        enhancer.setCallback(proxy1);
        House house1 = (House) enhancer.create();
        house1.buy();
    }
}
