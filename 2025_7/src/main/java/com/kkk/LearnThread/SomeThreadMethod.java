package com.kkk.LearnThread;

public class SomeThreadMethod {
    public static void main(String[] args) throws InterruptedException {
//        AThread t = new AThread();// 默认名称Thread-X（X是序号，从0开始）
//        t.start();
//        AThread t2 = new AThread("线程2");// 构造方法设置名称
//        t2.start();
//        AThread t3 = new AThread();
//        t3.setName("线程3");// setName设置名称
//        t3.start();

        /**
         * static Thread currentThread()
         * 当JVM虚拟机启动之后，会自动的启动多条线程
         * 其中有一条线程就叫做main线程
         * 它的作用就是去调用main方法，并执行里面的代码
         * 我们写的所有的代码，其实都是运行在main线程中
         */
//        Thread t4 = Thread.currentThread();
//        System.out.println(t4.getName());// 输出是main

        /**
         * static void sleep(long time) 指定线程进行休眠，单位ms
         * 哪条线程执行到这个方法，那么哪条线程就会在这里停留对应的时间
         * 方法的参数：就表示睡眠的时间
         */
//        System.out.println("11111111");
//        Thread.sleep(2000);
//        System.out.println("22222222");

        /**
         * setPriority(int newPriority) 设置线程的优先级
         * final int getPriority() 获取线程的优先级
         */
        // 创建线程要执行的参数对象
//        ARunnable ar = new ARunnable();
//        // 创建线程对象
//        Thread t5 = new Thread(ar,"飞机");
//        Thread t6 = new Thread(ar,"大炮");
//        // 看下优先级 结果都是5
//        System.out.println(t5.getPriority());
//        System.out.println(t6.getPriority());
//        // 看下main进程的优先级 也是5
//        System.out.println(Thread.currentThread().getPriority());
//        t5.setPriority(Thread.MIN_PRIORITY);
//        t6.setPriority(Thread.MAX_PRIORITY);
//        t5.start();
//        t6.start();

        /**
         * final void setDaemon(boolean on)
         * 当其他的非守护线程执行完毕后，守护线程会陆续结束
         */
//        MyThread1 t7 =  new MyThread1();
//        MyThread2 t8 =  new MyThread2();
//        t7.setName("线程7");
//        t8.setName("线程8");
//        //将线程8设置为守护线程
//        t8.setDaemon(true);
//        // 线程7打印10次结束后，线程8并没有执行100次，而是执行几十次就结束了
//        t7.start();
//        t8.start();

        /**
         * public static void yield() 出让线程/礼让线程
         */

//        MyThread3 t9 = new MyThread3();
//        MyThread3  t10 = new MyThread3();
//        t9.setName("飞机");
//        t10.setName("大炮");
//        t9.start();
//        t10.start();

        /**
         * public static void join() 插入线程/插队线程
         */

        MyThread4 t11 = new MyThread4();
        t11.setName("土豆");
        t11.start();

        // 表示把t11这个线程插入到当前线程之前，等t11线程全执行完毕后才执行main线程
        // t11：土豆线程
        // 当前线程：mian线程
        t11.join();

        // 以下代码是执行在main线程的
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程"+i);
        }
    }
}

class AThread extends Thread{
    public AThread(String s) {
        this.setName(s);
    }

    public AThread() {
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"@"+1);
        }
    }
}

class ARunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
}

class MyThread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"@"+i);
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"@"+i);
        }
    }
}

class MyThread3 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"@"+i);
            // 出让当前cpu的执行权
            Thread.yield();
        }
    }
}

class MyThread4 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"@"+i);
        }
    }
}