package com.kkk.LearnThread.ThreadPool;

public class GetCPUNumber {
    public static void main(String[] args) {
        //向Java虚拟机返回可用的处理器数目
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
    }
}
