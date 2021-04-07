package com.huchx.thread.features;

/**
 * Volatile 关键字的作用是变量在多个线程之间可见。
 * Volatile关键字将解决线程之间可见性, 强制线程每次读取该值的时候都去“主内存”中取值
 * Volatile不用具备原子性。
 */
public class VolatileThread extends Thread{
    public volatile boolean flag = true;
    @Override
    public void run() {
        System.out.println("开始执行子线程.......");
        while (flag){
            System.out.println(Thread.currentThread().getName()+"正在运行中......");
        }
        System.out.println("线程停止...........");
    }
    public void setRunning(boolean flag){
        this.flag = flag;
    }

    public static void main(String[] args) {
        VolatileThread volatileThread = new VolatileThread();
        volatileThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        volatileThread.setRunning(false);
        System.out.println("Flag已经设置为false");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("Flag:"+volatileThread.flag);


    }
}
