package com.kkk.set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo3 {
    public static void main(String[] args) {
        /**
         * 按照字符串长度排序
         * 采取第二种方式：比较器排序
         */

        //o1：表示当前要添加的元素
        //o2：已经添加到红黑树的元素
        //按照长度进行排序，如果长度一样就按照首字母
        TreeSet<String> set = new TreeSet<>((o1, o2) -> {
                int i = o1.length() - o2.length();
                return i == 0 ? o1.compareTo(o2) : i;
            }
        );

        set.add("c");
        set.add("ab");
        set.add("df");
        set.add("qwer");

        System.out.println(set);
    }
}
