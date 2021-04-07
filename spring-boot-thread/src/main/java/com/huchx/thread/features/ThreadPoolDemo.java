package com.huchx.thread.features;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Java通过Executors（jdk1.5并发包）提供四种线程池，分别为：
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class ThreadPoolDemo {
    //可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
    //线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
   static ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

    //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
    //因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
    //定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
   static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);

    //创建一个定长线程池，支持定时及周期性任务执行。
   static ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);

    //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    //结果依次输出，相当于顺序执行各个任务。
   static ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
//        testCachedPool();
//        testFixedPool();
//        testScheduledPool();
        testSinglePool();
    }
    /**
     * newSingleThreadPool测试
     *  结果依次输出，相当于顺序执行各个任务。
     */
    private static void testSinglePool() {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("index:" + index);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            });
        }
    }

    /**
     * newScheduledThreadPool测试
     * 延迟3秒执行。
     */
    private static void testScheduledPool() {
        newScheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.MILLISECONDS);
    }

    /**
     * newFixedThreadPool测试
     */
    private static void testFixedPool() {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newFixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println("i:" + index);
                }
            });
        }
    }

    /**
     * newCachedThreadPool测试
     * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
     */
    private static void testCachedPool() {
        for (int i = 0; i < 10; i++) {
            final int index = i;
             try {
             Thread.sleep(index * 1000);
             } catch (InterruptedException e) {
             e.printStackTrace();
             }
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "---" + index);
                }
            });
        }
    }

}
