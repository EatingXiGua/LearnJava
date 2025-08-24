package com.kkk.objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectStreamDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * 利用反序列化流/对象操作输入流，把本地文件中的对象读取到程序中来
         */

        //创建反序列化流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));

        //读数据
        Student o = (Student) ois.readObject();
        System.out.println(o);

        //释放资源
        ois.close();
    }
}
