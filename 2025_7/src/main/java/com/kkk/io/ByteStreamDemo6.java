package com.kkk.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamDemo6 {
    public static void main(String[] args) throws IOException {
        //一次读一个字节数组数据
        FileInputStream fis = new FileInputStream("a.txt");
        byte[] bytes = new byte[2];//一次读2个字节
        int len = fis.read(bytes);//一次读多少字节数据，具体读多少，跟数组的长度有关  返回值：本次读取到了多少个字节的数据
        System.out.println(len);
        String str = new String(bytes,0,len);
        System.out.println(str);
        fis.close();
    }
}
