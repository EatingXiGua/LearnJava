package com.kkk.zipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /**
         * 压缩文件夹
         */

        //创建File对象表示要压缩的文件夹
        File src = new File(".\\aaa");
        //创建File对象表示压缩包放在哪里（压缩包的父级路径）
        File destParent = src.getParentFile();
        //创建File对象表示压缩包的路径
        File dest = new File(destParent, src.getName()+".zip");
        //创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        //获取src中的每一个文件，变成ZipEntry对象，放入压缩包中
        toZip(src,zos,src.getName());
        //释放资源
        zos.close();
    }

    /**
     * 获取src里面的每一个文件，变成ZipEntry对象，放入到压缩包中
     * @param src 数据源
     * @param zos 压缩流
     * @param name 压缩包内部的路径
     */
    public static void toZip(File src,ZipOutputStream zos,String name) throws IOException {


        //进入src文件夹
        File[] files = src.listFiles();
        //遍历
        for(File file : files){
            if (file.isFile()){
                ZipEntry ze = new ZipEntry(name+"\\"+file.getName());
                zos.putNextEntry(ze);
                FileInputStream in = new FileInputStream(file);
                int b;
                while((b=in.read())!=-1){
                    zos.write(b);
                }
                in.close();
                zos.closeEntry();
            }else {
                toZip(file,zos,name+"\\"+file.getName());
            }
        }
    }
}
