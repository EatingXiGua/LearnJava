package com.kkk.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //第二个参数设置为true，实现续写，不会清空
        FileOutputStream fos = new FileOutputStream("a.txt", true);
        String str = "abc";
        byte[] bytes = str.getBytes();
        fos.write(bytes);
        //换行
        fos.write("\r\n".getBytes());
        fos.write(bytes);
        fos.close();
    }
}
