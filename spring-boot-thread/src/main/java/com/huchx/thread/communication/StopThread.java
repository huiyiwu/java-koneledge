package com.huchx.thread.communication;

/**
 * wait()、notify()、notifyAll()是三个定义在Object类里的方法，可以用来控制线程的状态。
 */
public class StopThread implements Runnable {
    private boolean flag = true;

    @Override
    public synchronized void run() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                flag = false;
//                e.printStackTrace();
            }
            notify();
            System.out.println("Thread Is Running。。。。");
        }
    }

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        Thread thread = new Thread(stopThread);
        Thread thread1 = new Thread(stopThread);
        thread.start();
        thread1.start();
        int i =0;
        while (true){
            System.out.println("Thread Main.......");
            if (i==10){
                thread1.interrupt();
                thread.interrupt();
                break;
            }
            i++;
        }
    }
}