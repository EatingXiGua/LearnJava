package com.kkk.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo4 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        //第三种遍历 Lambda表达式
        map.forEach(new BiConsumer<String, String>() {

            @Override
            public void accept(String key, String value) {
                System.out.println(key + " " + value);
            }
        });

        map.forEach(( key,  value)-> System.out.println(key + " " + value));
    }
}
