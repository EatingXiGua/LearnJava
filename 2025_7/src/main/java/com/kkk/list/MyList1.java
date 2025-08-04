package com.kkk.list;

import java.util.ArrayList;
import java.util.List;

public class MyList1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        //细节：原来索引处上的元素会依次往后移
        list.add(0,"A");
        list.add(1,"B");
        list.add(2,"C");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.set(1,"D");
        System.out.println(list);

        String s = list.get(1);
        System.out.println(s);

    }
}
