package com.kkk.bufferstream;

import java.io.*;

public class BufferStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //创建缓冲流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.txt"));
        //循环读取并写到目的地
        byte[] buf = new byte[1024];
        int len;
        while ((len=bis.read(buf))!=-1){
            bos.write(buf,0,len);
        }
        //释放资源
        bos.close();
        bis.close();
    }
}
