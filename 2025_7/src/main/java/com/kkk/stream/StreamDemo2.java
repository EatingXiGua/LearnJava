package com.kkk.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        //1.单列集合获取Stream流
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"a","b","c","d","e","f","g","h");
        Stream<String> stream = list.stream();//获取到一条流水线，并把集合中的数据放到流水线上
        stream.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        list.stream().forEach(s->System.out.println(s));//上两行简化为这一行

        //2.双列集合不能直接使用Stream流
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("a",1);
        hm.put("b",2);
        hm.put("c",3);
        hm.put("d",4);
        hm.keySet().stream().forEach(s->System.out.println(s));//用keySet获取所有的键，然后获取Stream流
        hm.entrySet().stream().forEach(s->System.out.println(s));//用entrySet获取所有的键值对对象，然后获取Stream流

        //3.数组获取Stream流
        int[] arr = {1,2,3,4,5};
        Arrays.stream(arr).forEach(s->System.out.println(s));

        //4.一堆零散的数据获取Stream流
        Stream.of("a","b","c").forEach(s->System.out.println(s));
        //注意：
        //Stream接口中静态方法of的细节
        //方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递一个数组
        //但是数组必须是引用数据类型的，如果传递基本数据类型，是会把整个数组当作一个元素放到Stream中
        Stream.of(arr).forEach(s->System.out.println(s));//打印的是地址[I@4769b07b
    }
}
