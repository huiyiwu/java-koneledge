package com.huchx.thread.features;

/**
 * ThreadLocal提供一个线程的局部变量，访问某个线程拥有自己局部变量。
 * void set(Object value)设置当前线程的线程局部变量的值。
 * public Object get()该方法返回当前线程所对应的线程局部变量。
 * public void remove()将当前线程局部变量的值删除，目的是为了减少内存的占用，该方法是JDK 5.0新增的方法。需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度。
 * protected Object initialValue()返回该线程局部变量的初始值，该方法是一个protected的方法，显然是为了让子类覆盖而设计的。这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次。ThreadLocal中的缺省实现直接返回一个null。
 * ThreadLoca通过map集合
 * Map.put(“当前线程”,值)；
 */
public class ThreadLocalThread extends Thread{
    private Res res;

    public ThreadLocalThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"------i------"+i+"------num:"+res.getNum());
        }
    }

    public static void main(String[] args) {
        Res res = new Res();
        ThreadLocalThread thread1 = new ThreadLocalThread(res);
        ThreadLocalThread thread2 = new ThreadLocalThread(res);
        ThreadLocalThread thread3 = new ThreadLocalThread(res);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
