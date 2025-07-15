package com.kkk.LearnThread.WaitAndNotifyBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {

    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            //不断的把食物放到阻塞队列中
            try {
                queue.put("面条");
                System.out.println("生产者将生产的食物放到了桌子上");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
