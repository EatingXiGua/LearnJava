package com.kkk.LearnThread.WaitAndNotifyBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class WaitAndNotify {
    /**
     * 生产者消费者（等待唤醒机制）
     * 实现线程轮流交替执行
     * 使用阻塞队列实现
     * 生产者和消费者使用的是一个阻塞队列
     */

    public static void main(String[] args) {

        //1.创建阻塞队列的对象
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Cook cook = new Cook(queue);
        Foodie foodie = new Foodie(queue);
        cook.start();
        foodie.start();
    }
}
