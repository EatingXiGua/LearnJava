package com.kkk.objectstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /**
         * 利用序列化流/对象操作输出流，把一个对象写到文件中
         */

        //创建对象
        Student s1 = new Student("John Smith", 22);

        //创建序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.txt"));

        //写数据
        oos.writeObject(s1);

        //释放资源
        oos.close();
    }
}
