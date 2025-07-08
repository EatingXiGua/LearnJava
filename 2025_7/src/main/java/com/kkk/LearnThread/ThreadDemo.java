package com.kkk.LearnThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 多线程的第一种实现方式
         * 1.自己定义一个类继承Thread
         * 2.重写run方法
         * 3.创建子类对象，并启动线程
         */

//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//        t1.setName("Thread1");
//        t2.setName("Thread2");
//        // 开启线程
//        t1.start();
//        t2.start();

        /**
         * 多线程的第二种实现方式：
         * 1.自己定义一个类实现Runnable接口
         * 2.重写里面的run方法
         * 3.创建自己的类的对象
         * 4.创建一个Thread类的对象，并开启线程
         */

        // 创建MyRun的对象
        // 表示多线程要执行的任务
//        MyRun mr = new MyRun();
//        // 创建线程对象
//        Thread t3 = new Thread(mr);
//        Thread t4 = new Thread(mr);
//        // 给线程设置名字
//        t3.setName("Thread3");
//        t4.setName("Thread4");
//        // 开启线程
//        t3.start();
//        t4.start();

        /**
         * 多线程的第三种实现方式
         * 特点：可以获取到多线程运行的结果
         * 1.创建一个类MyCallable实现Callbale接口
         * 2.重写call（是有返回值的，表示多线程运行的结果）
         * 3.创建MyCallable的对象（表示多线程要执行的任务）
         * 4.创建FutureTask的对象（作用管理多线程运行的结果）
         * 5.创建Thread类的对象，并启动（表示线程）
         */

        // 创建MyCallable的对象（表示多线程要执行的任务）
        MyCallable mc = new MyCallable();
        // 创建FutureTask的对象（作用管理多线程运行的结果）
        FutureTask<Integer> ft = new FutureTask<>(mc);

        Thread t5 = new Thread(ft);
        t5.start();
        // 获取多线程运行的结果
        Integer result = ft.get();
        System.out.println(result);
    }
}
