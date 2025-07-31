package com.kkk.file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        //1.根据字符串表示的路径创建文件对象
        String str = "C:\\Users\\xvke1\\Desktop\\a.txt";
        File file = new File(str);
        System.out.println(file);

        //2.根据父路径名和子路径名创建文件对象
        String parent = "C:\\Users\\xvke1\\Desktop";
        String child = "a.txt";
        File file1 = new File(parent, child);
        System.out.println(file1);

        File file2 = new File(parent+"\\"+child);
        System.out.println(file2);

        //3.根据父路径对应的文件对象和子路径创建文件对象
        File file3 = new File(parent);
        File file4 = new File(file3,child);
        System.out.println(file4);
    }
}
