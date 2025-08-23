package com.kkk.charstream;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");

        char[] chars = new char[2];
        int len;
        //read(chars):读取数据、解码、强转三步合并了，把强转之后的字符放到数组当中
        //相当于空参的read方法+强制类型转换
        while ((len = fr.read(chars)) != -1){
            System.out.print(new String(chars, 0, len));
        }
        fr.close();
    }
}
