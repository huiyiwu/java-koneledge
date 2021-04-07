package com.huchx.thread.simple;

public class InnerThread {
    public static void main(String[] args) {

        System.out.println("********************线程开始*******************");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("InnerThread: 第"+i+"打印");
                }
            }
        }).start();
        System.out.println("********************线程结束*******************");
    }
}
