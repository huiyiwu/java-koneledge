package com.huchx.thread.simple;

public class CustomRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnable：第"+i+"次打印");
        }
    }

    public static void main(String[] args) {
        System.out.println("********************线程开始*******************");
        CustomRunnable runnable = new CustomRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("********************线程结束*******************");
    }
}
