`线程`是一组指令的集合，或者是程序的特殊段，它可以在程序里独立执行。也可以把它理解为代码运行的上下文。所以线程基本上是轻量级的进程，它负责在单个程序里执行多任务。通常由操作系统负责多个线程的调度和执行。

@[toc]

# 1. 线程
## 1.1 线程和进程区别
进程是所有线程的集合，每一个线程是进程中的一条执行路径。
## 1.2. 应用场景
分批发送短信、批量多线程下载等功能
## 1.3.多线程创建方式
### 1.3.1 Thread类
```java
public class CustomThread  extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: 第"+i+"次打印");
        }
    }
    public static void main(String[] args) {
        System.out.println("********************线程开始*******************");
        CustomThread thread = new CustomThread();
        thread.start();
        System.out.println("********************线程结束*******************");
    }
}
```
运行main方法后结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210316152244340.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMyNTMwNTYx,size_16,color_FFFFFF,t_70)


### 1.3.2 Runnable接口
```java
public class CustomRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnable：第"+i+"次打印");
        }
    }

    public static void main(String[] args) {
        System.out.println("********************线程开始*******************");
        CustomRunnable runnable = new CustomRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("********************线程结束*******************");
    }
}
```
运行main方法执行后结果：
![](https://img-blog.csdnimg.cn/20210316152221160.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMyNTMwNTYx,size_16,color_FFFFFF,t_70)

### 1.3.3 匿名内部类
```java
public class InnerThread {
    public static void main(String[] args) {

        System.out.println("********************线程开始*******************");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("InnerThread: 第"+i+"打印");
                }
            }
        }).start();
        System.out.println("********************线程结束*******************");
    }
}

```
运行main方法后结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210316152736868.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMyNTMwNTYx,size_16,color_FFFFFF,t_70)
## 1.4. 实现方式比较
继承类后不可再继承，而接口可以继续继承。
## 1.5. 线程运行状态
### 1.5.1 新建状态
当使用New操作符创建新线程时，此时线程处于新建状态，但是没有运行。
### 1.5.2 就绪状态
&nbsp;&nbsp;&nbsp;&nbsp;调用线程的Start方式后创建系统运行的系统资源，并调度线程运行run方法。当start方法返回后线程处于就绪状态。
&nbsp;&nbsp;&nbsp;&nbsp;处于就绪状态的线程不一定立即运行run方法，其必须与其他线程竞争CPU资源，只有获得CPU资源才可以运行线程。对于单CPU的计算系统，同一时刻只有一个线程处于运行状态，对于其余多个处于就绪状态的线程，通过Java运行时系统的线程调度程序调度。
### 1.5.3 运行状态
当线程获得CPU资源后才进入运行状态，真正开始执行run方法。
### 1.5.4 阻塞状态
线程进入阻塞状态的原因：
* 线程调用sleep方法进入睡眠状态
* 线程调用一个在I/O上被阻塞的操作，即该操作在输入输出之前不会返回到其调用者
* 线程试图得到一个正被其他线程持有的锁
* 线程在等待某一个触发条件
### 1.5.5 死亡状态
出现死亡状态的原因：
* run方法正常退出线程死亡
* 一个未捕获的异常终止了run方法而使线程猝死
  可以使用isAlive方法判断线程是否可运行或被阻塞。
## 1.6 常用API
API|描述
---|---
Thread（）|分配新线程对象
Thread（String name）|分配新线程对象并指定名字
Thread（Runable）|分配新线程对象
Thread（Runnable r,String name）|分配新线程对象
start（）|启动线程
CurrentThread (）|获取当前线程对象
getID（）|获取当前线程ID，Thread编号从0开始
getName（）|获取当前线程名称
sleep (long mill)|休眠线程
stop ()|停止线程
# 2.多线程安全
## 2.1. 线程安全问题
当多个线程同时共享同一个全局变量或静态变量，做写的操作时，可能会发生数据冲突问题，这就是线程安全问题
## 2.2. 解决方法
多线程之间同步或使用锁(lock)。只让当前一个线程进行执行，代码执行完成后释放锁，然后才能让其他线程执行。这样当多个线程共享同一个资源时，不会受到其他线程的干扰。
### 2.2.1使用同步代码块
将可能会发生线程安全问题的代码块包括起来
```java
private Object mutex = new Object();//自定义锁
    private void changeTotal() {
        synchronized (mutex) {
            if (totalCount > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ",出售第(" + (100 - totalCount + 1) + "张票)");
                    totalCount--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
```
### 2.2.2.同步函数
在方法上使用`synchronized`修饰作为同步函数,此方法是使用`This锁`
```java
private synchronized void changeTotal() {
            if (totalCount > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ",出售第(" + (100 - totalCount + 1) + "张票)");
                    totalCount--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
```
### 2.2.3.静态同步函数
方法上加上`static`关键字，使用`synchronize`注释或者使用类.class文件。此方法是使用`字节文件`作为锁
```java
//    public static synchronized void changeTotal() {
        private void changeTotal() {
        synchronized (Train3Thread.class) {
            if (totalCount > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ",出售第(" + (100 - totalCount + 1) + "张票)");
                    totalCount--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
```
## 2.3. 死锁
同步中嵌套同步，导致锁无法释放
## 线程特性
原子性：保证数据一致性、线程安全的一部分，需要使用同步和lock保证此特性
可见性：当多个线程访问同一个变量时，一个线程修改了此变量的值，其他线程能够立即看到修改的值
有序性：程序执行的先后顺序按照代码的先后顺序执行