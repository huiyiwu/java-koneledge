package com.huchx.thread.communication;

/**
 * join作用是让其他线程变为等待
 */
public class JoinThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"----i:"+i);
        }
    }

    public static void main(String[] args) {
        JoinThread joinThread = new JoinThread();
        Thread thread1 = new Thread(joinThread);
        Thread thread2 = new Thread(joinThread);
        thread1.start();
        thread2.start();
        try {
            //让其他线程等待thread1线程执行完成后执行
            thread1.join();
        } catch (InterruptedException e) {

        }
        for (int i = 0; i < 100; i++) {
            System.out.println("Main------i:"+i);
        }
    }
}
