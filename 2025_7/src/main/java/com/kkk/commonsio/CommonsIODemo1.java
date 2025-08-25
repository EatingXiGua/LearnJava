package com.kkk.commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIODemo1 {
    public static void main(String[] args) throws IOException {
        /**
         * CommonsIO工具包的使用
         * FileUtils类
         * IOUtils类
         */

        File src = new File("a.txt");
        File dest = new File("b.txt");
        FileUtils.copyFile(src,dest);

        File src1 = new File(".\\aaa");
        File dest1 = new File(".\\bbb");
        FileUtils.copyDirectory(src1,dest1);//拷贝的是文件夹的内容 把aaa文件夹的内容拷贝到bbb文件夹内
        FileUtils.copyDirectoryToDirectory(src1,dest1);//拷贝的是整个文件夹 把aaa文件夹拷贝到bbb文件夹内
    }
}
