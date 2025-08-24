package com.kkk.bufferstream;

import java.io.*;

public class BufferStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        //读一行
        //readLine方法再读取的时候，一次读一整行，遇到回车换行结束，但是它不会把回车换行读到内存中
        String line = br.readLine();
        System.out.println(line);
        //释放资源
        br.close();

        //创建字符缓存输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt",true));
        bw.write("春花秋月何时了");
        bw.newLine();
        bw.write("往事知多少");
        bw.newLine();
        bw.close();
    }
}
