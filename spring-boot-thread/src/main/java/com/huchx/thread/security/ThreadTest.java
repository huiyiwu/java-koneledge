package com.huchx.thread.security;

public class ThreadTest {
    private int j =1;
    class ThreadOne implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                add();
            }
        }
    }

    private synchronized   void add() {
        j++;
        System.out.println("线程"+ Thread.currentThread().getName()+"执行加一后J的结果为："+j);
    }

    class ThreadTwo implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                sub();
            }
        }
    }

    private synchronized void sub() {
        j--;
        System.out.println("线程"+ Thread.currentThread().getName()+"执行减一后J的结果为："+j);
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadOne threadOne = threadTest.new ThreadOne();
        ThreadTwo threadTwo = threadTest.new ThreadTwo();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadOne,"一");
            thread.start();
            Thread thread1 = new Thread(threadTwo,"二");
            thread1.start();
        }
    }
}
