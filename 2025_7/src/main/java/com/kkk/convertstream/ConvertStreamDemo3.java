package com.kkk.convertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /**
         * 将本地文件的gbk文件转成utf-8
         */

        //jdk11之前的写法
        InputStreamReader isr = new InputStreamReader(new FileInputStream("b.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("c.txt"),"UTF-8");
        int b;
        while ((b=isr.read())!=-1){
            osw.write(b);
        }
        isr.close();
        osw.close();

        //jdk11后的写法
        FileReader fr = new FileReader("b.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("d.txt", Charset.forName("UTF-8"));
        int c;
        while ((c=fr.read())!=-1){
            fw.write(c);
        }
        fr.close();
        fw.close();
    }
}
