package com.kkk.charstream;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("a.txt", true);
        fw.write(25105);//我 的UTF-8是 25105
        fw.write("春花秋月何时了");
        fw.write("春花秋月何时了",0,2);
        char[] chars = {'春', 'b', 'c'};
        fw.write(chars);
        fw.write(chars,0,1);
        fw.close();
    }
}
