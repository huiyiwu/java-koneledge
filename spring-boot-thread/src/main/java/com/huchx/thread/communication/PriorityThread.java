package com.huchx.thread.communication;

/**
 * priority来控制优先级，范围为1-10，其中10最高，默认值为5。
 */
public class PriorityThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"----i:"+i);
        }
    }

    public static void main(String[] args) {
        PriorityThread priorityThread = new PriorityThread();
        Thread thread = new Thread(priorityThread);
        Thread thread1 = new Thread(priorityThread);
        thread.start();
        // 设置了优先级， 不代表每次都一定会被执行。 只是CPU调度会有限分配
        thread.setPriority(10);
        thread1.start();
    }
}
