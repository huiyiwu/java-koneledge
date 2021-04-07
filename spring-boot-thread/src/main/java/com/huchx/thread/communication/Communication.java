package com.huchx.thread.communication;

/**
 * 线程间通信
 */
public class Communication {
    static class User{
        public String userSex;
        public String userName;
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
                if (count==0){
                    user.userName="王金";
                    user.userSex="男";
                }else {
                    user.userName="谢欣";
                    user.userSex="女";
                }
                count = (count+1)%2;
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
                    System.out.println(user.userName+"--"+user.userSex);
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
