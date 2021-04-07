package com.huchx.thread.simple;

public class CustomThread  extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: 第"+i+"次打印");
        }
    }
    public static void main(String[] args) {
        System.out.println("********************线程开始*******************");
        CustomThread thread = new CustomThread();
        thread.start();
        System.out.println("********************线程结束*******************");
    }
}
