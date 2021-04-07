package com.huchx.design.pattern.proxy;

public class People implements House{

    @Override
    public void buy() {
        System.out.println("我要买房子啦......");
    }
}
