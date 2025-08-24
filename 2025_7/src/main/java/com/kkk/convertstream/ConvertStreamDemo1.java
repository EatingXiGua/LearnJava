package com.kkk.convertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /**
         * 利用转换流按照指定字符编码读取（了解） 因为jdk11这种方式就被淘汰了
         */

//        //创建对象并指定字符编码
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("gbkfile.txt"),"GBK");
//        //读取数据
//        int ch;
//        while ((ch=isr.read())!=-1){
//            System.out.print((char)ch);
//        }
//        //释放资源
//        isr.close();


        //现在的方法
        FileReader fr = new FileReader("gbkfile.txt", Charset.forName("GBK"));
        //读取数据
        int c;
        while ((c=fr.read())!=-1){
            System.out.print((char)c);
        }
        //释放资源
        fr.close();
    }
}
