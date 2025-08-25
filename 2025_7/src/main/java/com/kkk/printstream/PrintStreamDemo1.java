package com.kkk.printstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class PrintStreamDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * 字节打印流
         */

        //创建字节打印流对象
        PrintStream ps = new PrintStream(new FileOutputStream("a.txt"),true, Charset.forName("UTF-8"));
        //写出数据
        ps.println(97);//写出+自动刷新+自动换行
        ps.print(true);
        ps.printf("%s爱上了%s","a","b");
        //释放资源
        ps.close();
    }
}
