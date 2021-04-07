package com.huchx.thread.features;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Volatile不用具备原子性
 * AtomicInteger原子性,使用同步和lock保证原子性
 *
 */
public class VolatileNoAtomicThread extends Thread{
    private static volatile int count =0;
    private static  AtomicInteger atomicInteger = new AtomicInteger(0);
    private static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        addCount();
        lock.unlock();

    }

    private static void addCount() {
//        for (int i = 0; i < 1000; i++) {
//            count++;
//        }
//        System.out.println("count:"+count);

        for (int i = 0; i < 500; i++) {
            count =  atomicInteger.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName()+"-----count:" + count);
    }

    public static void main(String[] args) {
        VolatileNoAtomicThread[] threads = new VolatileNoAtomicThread[100];
        for (int i = 0; i < 10; i++) {
            threads[i] = new VolatileNoAtomicThread();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
