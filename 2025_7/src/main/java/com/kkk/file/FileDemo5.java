package com.kkk.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo5 {
    public static void main(String[] args) {
        //获取可用的文件系统根 就是获取系统中所有的盘符
        File[] arr = File.listRoots();
        System.out.println(Arrays.toString(arr));

        //获取当前路径下的所有内容（仅获取名字）
        File f1 = new File("C:\\Users\\xvke1\\Desktop\\aaa");
        String[] arr2 = f1.list();
        for (String str : arr2) {
            System.out.println(str);
        }

        //利用文件名过滤器获取当前路径下的所有内容
        //需求：获取这个目录所有的txt文件
        File f2 = new File("C:\\Users\\xvke1\\Desktop\\aaa");
        String[] arr3 = f2.list(new FilenameFilter() {
            //accept方法的形参，依次表示aaa文件夹里面每一个文件或者文件夹的路径
            //参数1：父级路径 参数2：子级路径 返回值：true 表示当前路径保留  false 表示当前路径舍弃
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);
                return src.isFile() && name.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(arr3));

        //使用listFiles方法打印指定目录下所有的txt文件
        File f3 = new File("C:\\Users\\xvke1\\Desktop\\aaa");
        File[] arr4 = f3.listFiles();
        for (File file : arr4) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println(file.getName());
            }
        }

        //利用文件名过滤器获取当前路径下的所有内容
        File f4 = new File("C:\\Users\\xvke1\\Desktop\\aaa");
        File[] arr5 = f4.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(arr5));

        //利用文件名过滤器获取当前路径下的所有内容
        File f5 = new File("C:\\Users\\xvke1\\Desktop\\aaa");
        File[] arr6 = f5.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);
                return src.isFile() && name.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(arr6));
    }
}
