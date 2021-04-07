package com.huchx.thread.communication;

/**
 * wait()、notify()、notifyAll()是三个定义在Object类里的方法，可以用来控制线程的状态。
 */
public class Wait {
    static class User{
        public String userSex;
        public String userName;
        //线程通讯标识
        public boolean flag=false;
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
                //解决线程安全问题
                synchronized (user){
                    if (user.flag){
                        try {
                            user.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                if (count==0){
                    user.userName="王金";
                    user.userSex="男";
                }else {
                    user.userName="谢欣";
                    user.userSex="女";
                }
                count = (count+1)%2;
                user.flag = true;
                user.notify();
                }
            }
        }
    }
    static class OutThread extends Thread{
        private User user;

        public OutThread(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            while (true){
                synchronized (user){
                    if (!user.flag){
                        try {
                            user.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(user.userName+"--"+user.userSex);
                    user.flag=false;
                    user.notify();
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
