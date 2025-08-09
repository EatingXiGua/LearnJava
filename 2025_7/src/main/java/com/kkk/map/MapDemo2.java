package com.kkk.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class MapDemo2 {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        //第一种遍历 键找值
        //获取所有的键，把这些键放到一个单列集合中
        Set<String> keySet = map.keySet();
        //遍历单列集合，得到每一个键
        for (String key : keySet) {
            //利用map集合获取集合中键对应的值
            System.out.println(key + ":" + map.get(key));
        }

        System.out.println("---------------------");

        //定义一个单列集合的迭代器去进行遍历
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + map.get(key));
        }

        System.out.println("---------------------");

        //使用Lambda表达式遍历
        keySet.forEach(new Consumer<String>() {
            @Override
            public void accept(String key) {
                System.out.println(key+":"+map.get(key));
            }
        });
        keySet.forEach(key -> System.out.println(key+":"+map.get(key)));
    }
}
