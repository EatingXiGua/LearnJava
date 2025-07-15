package com.kkk.LearnThread.WaitAndNotify;

public class Foodie extends Thread {

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
            synchronized (Desk.lock){
                if (Desk.count == 0){
                    break;
                }else {
                    //判断桌子上有没有面条
                    if (Desk.foodFlag == 1){
                        //有就开吃
                        //可以吃的总数-1
                        Desk.count--;
                        System.out.println("消费者正在吃面条，还可以吃"+Desk.count+"碗");
                        //吃完后唤醒生产者继续生产
                        Desk.lock.notifyAll();//唤醒锁绑定的所有线程
                        //修改桌子的状态
                        Desk.foodFlag = 0;
                    }else {
                        //没有就等待
                        try {
                            Desk.lock.wait();//用当前线程的锁对象去调用wait，这样可以绑定当前线程和锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        }
    }
}
