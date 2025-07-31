package com.kkk.file;

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {
        String str = "C:\\Users\\xvke1\\Desktop";
        File file = new File(str);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
    }
}
