package com.huchx.design.pattern.proxy;

import javax.swing.*;

/**
 * @静态代理
 * 自己生成代理类
 */
public class StaticProxy implements House {

    private People people;

    public StaticProxy(People people) {
        this.people = people;
    }

    @Override
    public void buy() {
        System.out.println("我是代理，开始带你买房啦.......");
        people.buy();
        System.out.println("我是代理，带你你买房结束啦.......");
    }
}
