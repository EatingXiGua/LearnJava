package com.kkk.zipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException {

        //创建一个File表示要解压的压缩包
        File src = new File("aaa.zip");
        //创建一个File表示解压的目的地
        File dest = new File(".//");
        //调用方法
        unzip(src,dest);
    }

    private static void unzip(File src, File dest) throws IOException {
        // 解压本质：把每一个ZipEntry按照层级拷贝到本地另一个文件夹中

        // 创建一个解压缩流用来读取压缩包中的数据
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        //要先获取到压缩包中的每一个ZipEntry对象
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            //文件夹：需要在目的地dest处创建一个同样的文件夹
            if (entry.isDirectory()) {
                File f = new File(dest, entry.getName());
                f.mkdirs();
            }
            //文件：需要读取到压缩包中的文件，并把它存放到目的地dest文件夹中（按照层级目录进行存放）
            else {
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.getName()));
                int b;
                while ((b = zis.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                //表示在压缩包中的一个文件处理完成
                zis.closeEntry();
            }
        }
        zis.close();
    }
}
