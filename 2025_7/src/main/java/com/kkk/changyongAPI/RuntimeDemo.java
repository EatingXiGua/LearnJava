package com.kkk.changyongAPI;

import java.io.IOException;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        //获取当前系统运行环境对象
        Runtime runtime = Runtime.getRuntime();
        //停止虚拟机
        //runtime.exit(0);
        //cpu线程数
        System.out.println(runtime.availableProcessors());
        //jvm能从系统中获取总内存大小 MB
        System.out.println(runtime.maxMemory()/1024/1024);
        //jvm剩余内存大小 MB
        System.out.println(runtime.freeMemory()/1024/1024);
        //jvm已经从系统中获取总内存大小 MB
        System.out.println(runtime.totalMemory()/1024/1024);
        //cmd 打开记事本
        runtime.exec("notepad");
    }
}
