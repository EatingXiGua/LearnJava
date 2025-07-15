package com.kkk.LearnThread;

public class DeadLock {

    public static void main(String[] args) {
        /**
         * 死锁
         */
        ABThread t1 = new ABThread();
        ABThread t2 = new ABThread();

        t1.setName("线程A");
        t2.setName("线程B");

        t1.start();
        t2.start();
    }
}
