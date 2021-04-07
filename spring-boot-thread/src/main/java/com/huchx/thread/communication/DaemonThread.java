package com.huchx.thread.communication;

/**
 *  Java中有两种线程，一种是用户线程，另一种是守护线程。
 *  当进程不存在或主线程停止，守护线程也会被停止。
 *  使用setDaemon(true)方法设置为守护线程
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                    }
                    System.out.println("子线程运行。。。。。。");
                }
            }
        });
        //设置为守护线程，当主线程运行完毕后线程停止
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i <10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("主线程运行。。。。。");
        }
        System.out.println("主线程运行完毕");
    }
}
