package com.kkk.hutooltest;


import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;

public class HutoolDemo {
    public static void main(String[] args) {
        /**
         * Hutool工具包
         * FileUtil类
         */

        File file = FileUtil.file("D:\\", "aaa", "bbb", "a.txt");
        System.out.println(file);

        File touch = FileUtil.touch(file);
        System.out.println(touch);

        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        File file1 = FileUtil.writeLines(list,"a.txt","UTF-8");
        System.out.println(file1);

        File file2 = FileUtil.appendLines(list, "a.txt", "UTF-8");
        System.out.println(file2);
    }
}
