package com.kkk.file;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        //创建一个新的空文件
        //1.要创建的文件存在，就会创建失败，返回false
        //2.父级路径不存在，异常IOException
        //3.创建的一定是一个文件，不写后缀名也是创建一个没有后缀名的文件
        String str = "C:\\Users\\xvke1\\Desktop\\b.txt";
        File file = new File(str);
        file.createNewFile();
        //创建单级文件夹
        String str1 = "C:\\Users\\xvke1\\Desktop\\aaa";
        File file1 = new File(str1);
        file1.mkdir();
        //创建多级文件夹 这个方法既可以创建单级文件夹，也可以创建多级文件夹
        String str2 = "C:\\Users\\xvke1\\Desktop\\bbb\\ccc";
        File file2 = new File(str2);
        file2.mkdirs();
        //删除文件、空文件夹
        //1.删除文件 直接删除 不走回收站
        //2.删除空文件夹 直接删除 不走回收站
        //3.删除有内容的文件夹 删除失败
        file.delete();
        file1.delete();
        file2.delete();
    }
}
