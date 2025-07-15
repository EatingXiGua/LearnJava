package com.kkk.LearnThread.WaitAndNotify;

public class WaitAndNotify {
    /**
     * 生产者消费者（等待唤醒机制）
     * 实现线程轮流交替执行
     */

    public static void main(String[] args) {
        Cook cook = new Cook();
        Foodie foodie = new Foodie();
        cook.start();
        foodie.start();
    }
}
