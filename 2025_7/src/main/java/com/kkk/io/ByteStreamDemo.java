package com.kkk.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
    public static void main(String[] args) throws IOException {
        //字节输出流 FileOutputStream

        //创建对象 a.txt不存在则创建，但是要保证父级目录存在；a.txt存在则清空
        FileOutputStream fos = new FileOutputStream("a.txt");
        //一次写一个字节
        fos.write(97);
        //一次写一个字节数组
        byte[] bytes = {97,98,99,100,101};
        fos.write(bytes);
        //一次写一个字节数组的部分数据 从2索引开始写，写3个
        fos.write(bytes,2,3);
        fos.close();
    }
}
