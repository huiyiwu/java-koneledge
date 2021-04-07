package com.huchx.thread.security;

/**
 * 使用同步函数解决多线程数据不同步问题
 * 使用This锁
 */
public class Train2Thread implements Runnable{
    private int totalCount = 100;
    @Override
    public void run() {
        while (totalCount>0){
            try {
                Thread.sleep(10);
                changeTotal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private Object mutex = new Object();
    private synchronized void changeTotal() {
            if (totalCount > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ",出售第(" + (100 - totalCount + 1) + "张票)");
                    totalCount--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public static void main(String[] args) {
        Train2Thread thread = new Train2Thread();
        Thread thread1 = new Thread(thread,"1号窗口");
        Thread thread2 = new Thread(thread,"2号窗口");
        thread1.start();
        thread2.start();
    }
}
