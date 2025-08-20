package com.kkk.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        //a.txt -> b.txt
        FileOutputStream fos = new FileOutputStream("b.txt");
        FileInputStream fis = new FileInputStream("a.txt");

        int len;
        byte[] bytes = new byte[2];
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        fis.close();
        fos.close();

        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
    }
}
