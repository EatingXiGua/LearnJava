package com.kkk.convertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /**
         * 利用转换流按照指定字符编码写出（了解） 因为jdk11这种方式就被淘汰了
         */

//        //创建转换流对象
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("b.txt"),"GBK");
//        osw.write("你好你好");
//        osw.close();

        FileWriter fr = new FileWriter("b.txt", Charset.forName("GBK"));
        fr.write("你好你好你好");
        fr.close();
    }
}
