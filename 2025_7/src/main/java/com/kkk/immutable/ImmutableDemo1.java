package com.kkk.immutable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableDemo1 {
    public static void main(String[] args) {
        /**
         * 创建不可变集合
         */

        //一旦创建完毕后，不可修改
        List<String> list = List.of("张三", "李四", "王五", "赵六");
        //list.remove("张三");//会报错

        //Set集合的细节：当我们要获取一个不可变的Set集合时，要保证里面参数的唯一性，比如说不能有两个张三
        Set<String> set = Set.of("张三", "李四", "王五", "赵六");

        //Map集合的细节:1.键不能重复 2.Map里面的of方法，参数是有上限的，最多只能传递20个参数，即10个键值对
        //解释一下为什么，如果想接收n个键值对，就需要用到可变参数，不知道键和值的类型，需要泛型，然后可变参数在
        //一个方法中最多写一个，这里要写两个，所以就没有这个方法
        Map<String, String> map = Map.of("key1", "value1", "key2", "value2", "key3", "value3");

        //创建Map的不可变集合，且键值对的数量超过10个
        //1.创建一个普通的Map集合
        HashMap<String,String> hm = new HashMap<>();
        hm.put("key1", "value1");
        hm.put("key2", "value2");
        hm.put("key3", "value3");
        hm.put("key4", "value4");
        hm.put("key5", "value5");
        hm.put("key6", "value6");
        hm.put("key7", "value7");
        hm.put("key8", "value8");
        hm.put("key9", "value9");
        hm.put("key10", "value10");
        hm.put("key11", "value11");
        //2.利用上面的数据获取一个不可变的集合
        //获取到所有的键值对对象（Entry对象）
        Set<Map.Entry<String,String>> entries = hm.entrySet();
        //把entries变成一个数组
        //hm.size() 这是要创建的array数组的长度，这里写跟hm长度一样，也可以不一样new Map.Entry[0]可以，new Map.Entry[20]也可以
        //toArray方法在底层会比较集合的长度和数组的长度两者的大小
        //如果集合的长度>数组的长度：数据在数组中放不下，此时会根据实际数据的个数，重新创建数组
        //如果集合的长度<=数组的长度：数据在数组中能放下，此时不会创建新的数组，会直接用，多余的部分赋值默认值null
        Map.Entry[] array = entries.toArray(new Map.Entry[hm.size()]);
        //不可变map集合
        Map map1 = Map.ofEntries(array);
        //map1.put("key1", "value1");//会报错，不允许添加

        //上面的代码写一行就是这样
        Map<Object, Object> map2 = Map.ofEntries(hm.entrySet().toArray(new Map.Entry[hm.size()]));

        //jdk10后可以用copyOf直接定义不可变集合
        Map<String, String> map3 = Map.copyOf(hm);
    }
}
