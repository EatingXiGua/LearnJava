package com.kkk.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class MapDemo3 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        //第二种方式 键值对方式进行遍历
        //通过一个方法获取所有的键值对对象，返回一个Set集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //遍历entries这个集合。去得到里面的每一个键值对
        for (Map.Entry<String, String> entry : entries) {
            //利用entry调用get方法获取键和值
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("---------------------");

        //迭代器
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("---------------------");

        //Lambda表达式
        entries.forEach(new Consumer<Map.Entry<String, String>>() {

            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                System.out.println(stringStringEntry.getKey() + ":" + stringStringEntry.getValue());
            }
        });
        entries.forEach(stringStringEntry-> System.out.println(stringStringEntry.getKey() + ":" + stringStringEntry.getValue()));
    }
}
