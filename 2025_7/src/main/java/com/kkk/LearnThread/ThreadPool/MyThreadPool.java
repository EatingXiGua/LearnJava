package com.kkk.LearnThread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
    public static void main(String[] args) throws InterruptedException {
        /**
         * public static ExecutorService newCachedThreadPool() 创建没有上限的线程池
         * public static ExecutorService newFixedThreadPool(int nThreads) 创建有上限的线程池
         */

        //1.获取线程池对象
        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newFixedThreadPool(3);
        //2.提交任务
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        //3.销毁线程池
        //pool.shutdown();
    }
}
