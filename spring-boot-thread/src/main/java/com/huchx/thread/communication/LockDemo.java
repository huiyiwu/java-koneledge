package com.huchx.thread.communication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在 jdk1.5 之后，并发包中新增了 Lock 接口(以及相关实现类)用来实现锁功能，Lock 接口提供了与 synchronized 关键字类似的同步功能，但需要在使用时手动获取锁和释放锁。
 */
public class LockDemo {
    static class User{
        public String userSex;
        public String userName;
        //线程通讯标识
        public boolean flag=false;
    }
    static class IntThread extends Thread{
        private User user;
        private Lock lock = new ReentrantLock();

        public IntThread(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            int count=0;
            while (true){
                //解决线程安全问题
                synchronized (user){
             lock.lock();
                if (count==0){
                    user.userName="王金";
                    user.userSex="男";
                }else {
                    user.userName="谢欣";
                    user.userSex="女";
                }
                count = (count+1)%2;
                lock.unlock();
                }
            }
        }
    }
    static class OutThread extends Thread{
        private User user;
        private Lock lock = new ReentrantLock();

        public OutThread(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            while (true){
                synchronized (user){
                   lock.lock();
                    System.out.println(user.userName+"--"+user.userSex);
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        User user = new User();
        IntThread intThread = new IntThread(user);
        OutThread outThread = new OutThread(user);
        intThread.start();
        outThread.start();
    }
}
