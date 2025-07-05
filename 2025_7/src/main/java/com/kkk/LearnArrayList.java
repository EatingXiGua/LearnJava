package com.kkk;

import java.util.ArrayList;

public class LearnArrayList {
    public static void main(String[] args) {
        // 定义一个ArrayList，保存类型String
        ArrayList<String> list = new ArrayList<>();
        // 添加一个元素到末尾，返回值是boolean，表示是否添加成功
        boolean a1 = list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        // 添加一个元素到指定位置，没有返回值
        list.add(0,"D");
        // 移除指定位置元素，返回被删除元素
        String remove = list.remove(0);
        // 移除指定元素，返回值表示是否删除成功
        boolean a = list.remove("A");
        // 修改指定位置的元素，返回原来的元素
        String e = list.set(0, "E");
        // 获取指定位置的元素
        String s = list.get(2);
        // 获取ArrayList的大小
        int size = list.size();
        // 打印，结果会被[]包围
        System.out.println(list);
        // 定义另外一个ArrayList，用list赋值
        ArrayList<String> list1 = new ArrayList<>(list);
        System.out.println(list1);
    }
}
