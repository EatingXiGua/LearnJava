package com.kkk.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /**
         * 字符打印流
         */

        //创建字符打印流
        PrintWriter pw = new PrintWriter(new FileWriter("a.txt"), true);
        //写数据
        pw.println("春花秋月");//写出+自动刷新+自动换行
        pw.print("123");
        pw.printf("%s爱上了%s","a","b");
        //释放资源
        pw.close();
    }
}
