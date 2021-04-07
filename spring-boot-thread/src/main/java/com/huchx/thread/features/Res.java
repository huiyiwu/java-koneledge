package com.huchx.thread.features;

public class Res {
    public static Integer count = 0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public Integer getNum(){
        int count = threadLocal.get()+1;
        threadLocal.set(count);
        return count;
    }
}
