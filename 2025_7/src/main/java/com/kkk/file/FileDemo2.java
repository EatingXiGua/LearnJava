package com.kkk.file;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FileDemo2 {
    public static void main(String[] args) {
        String str = "C:\\Users\\xvke1\\Desktop\\a.txt";
        File file = new File(str);
        //判断此路径表示的File是否是文件夹
        boolean r1 = file.isDirectory();
        //判断此路径表示的File是否是文件
        boolean r2 = file.isFile();
        //判断此路径表示的File是否存在
        boolean r3 = file.exists();
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        //返回文件的长度 1.获取到的文件大小的单位是字节 2.无法获取文件夹的大小
        long length = file.length();
        System.out.println(length);
        //返回文件的绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        //返回定义文件时使用的路径 写的是绝对路径就返回绝对路径，写的是相对路径就返回相对路径
        String path = file.getPath();
        System.out.println(path);
        //返回文件的名称，带后缀
        String name = file.getName();
        System.out.println(name);
        //返回文件的最后修改时间（时间毫秒值）
        long time = file.lastModified();
        System.out.println(time);
        Instant instant = Instant.ofEpochMilli(time);
        System.out.println(instant);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(formatter.format(zonedDateTime));
    }
}
