package com.kkk.generics;

public class UseMyArrayList {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String s = list.get(1);
        System.out.println(s);
        String string = list.toString();
        System.out.println(string);
    }
}
