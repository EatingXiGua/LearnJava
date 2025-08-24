package com.kkk.convertstream;

import java.io.*;

public class ConvertStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /**
         * 利用字节流读取文件中的数据，每次读一整行，而且不能出现乱码
         *
         * 字节流中没有读一整行的方法，字符缓冲流中有这个方法
         */

        //字节输入流
        FileInputStream fis = new FileInputStream("a.txt");
        //转换流
        InputStreamReader isr = new InputStreamReader(fis);
        //字符缓冲输入流
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine();
        System.out.println(str);

        br.close();
    }
}
