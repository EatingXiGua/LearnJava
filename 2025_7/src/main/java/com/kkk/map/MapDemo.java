package com.kkk.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        //添加元素
        //添加/覆盖
        //在添加数据的时候，如果键不存在，那么直接把键值对对象添加到map集合中，方法返回null
        //在添加数据的时候，如果键存在，那么会把原来的键值对对象覆盖，会把被覆盖的值进行返回
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        System.out.println(map);

        //判断集合是否包含指定的键
        boolean r = map.containsKey("key1");
        System.out.println(r);

        //判断集合是否包含指定的值
        boolean r2 = map.containsValue("value1");
        System.out.println(r2);

        //集合长度，即键值对数量
        int size = map.size();
        System.out.println(size);

        //根据键删除键值对
        map.remove("key1");

        //移除所有的键值对
        map.clear();

        //判断集合是否为空
        boolean empty = map.isEmpty();
        System.out.println(empty);


    }
}
