package com.kkk.LearnThread.WaitAndNotify;

public class Cook extends Thread {

    @Override
    public void run() {
        /**
         * 1.循环
         * 2.同步代码快
         * 3.判断共享数据是否到了末尾（到了）
         * 4.判断共享数据是否到了末尾（没有到，执行核心逻辑）
         *
         */

        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0){
                    break;
                }else {
                    //判断桌子上有没有食物
                    if (Desk.foodFlag == 1){
                        //有就等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        //没有就制作食物，即改变桌子的状态
                        Desk.foodFlag = 1;
                        //把食物放在桌子上
                        System.out.println("生产者将生产的食物放到了桌子上");
                        //唤醒等待的消费者
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
