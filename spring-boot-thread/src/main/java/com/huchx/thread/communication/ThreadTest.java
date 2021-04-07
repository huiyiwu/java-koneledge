package com.huchx.thread.communication;

/**
 * 有T1、T2、T3三个线程，如何怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 */
public class ThreadTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"----i:"+i);
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Thread thread1 = new Thread(threadTest);
        Thread thread2 = new Thread(threadTest);
        Thread thread3 = new Thread(threadTest);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
        }
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {

        }
        thread3.start();
    }
}
