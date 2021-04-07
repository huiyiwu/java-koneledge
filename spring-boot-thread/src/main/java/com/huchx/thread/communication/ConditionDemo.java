package com.huchx.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  Condition的功能类似于在传统的线程技术中的,Object.wait()和Object.notify()的功能,
 */
public class ConditionDemo {
    static class User{
        public String userSex;
        public String userName;
        private boolean flag =  false;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

    }
    static class IntThread extends Thread{
        private User user;
        public IntThread(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            int count=0;
            while (true){
                    try {
                        user.lock.lock();
                        if (user.flag) {
                            user.condition.await();
                        }
                        System.out.println("我陷入了等待......");

                        if (count==0){
                            user.userName="王金";
                            user.userSex="男";
                        }else {
                            user.userName="谢欣";
                            user.userSex="女";
                        }
                        count = (count+1)%2;
                        user.flag = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        user.condition.signal();
                        user.lock.unlock();
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
                    user.lock.lock();
                    try {
                        if (!user.flag){
                            user.condition.await();
                        }
                        System.out.println(user.userName+"--"+user.userSex);
                        user.flag = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        user.condition.signal();
                        user.lock.unlock();
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
