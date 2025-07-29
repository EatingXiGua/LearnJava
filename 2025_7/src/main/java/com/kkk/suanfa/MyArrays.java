package com.kkk.suanfa;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrays {
    public static void main(String[] args) {
        //toString：将数组变成字符串
        System.out.println("--------------------toString-------------------");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arr));

        //binarySearch:二分查找法查找元素
        //细节：二分查找的前提：数组中的元素必须有序，必须升序
        //如果要查找的元素是存在的，那么返回的是真实的索引。如果不存在，返回的是 - 插入点 -1
        //为什么-1？因为如果查找0，0不存在，返回-0，-0也是0，会产生误解，所以再减一
        System.out.println("-------------------binarySearch----------------------");
        System.out.println(Arrays.binarySearch(arr, 10));//9
        System.out.println(Arrays.binarySearch(arr, 2));//1
        System.out.println(Arrays.binarySearch(arr, 20));//-11

        //copyOf:拷贝数组 参数一：老数组 参数二：新数组的长度
        //方法的底层会根据第二个参数来创建新的数组
        //如果新数组的长度小于老数组的长度，会部分拷贝
        //如果新数组的长度等于老数组的长度，会完全拷贝
        //如果新数组的长度大于老数组的长度，会补上默认初始值
        System.out.println("--------------------copyOf----------------------");
        int[] arr2 = Arrays.copyOf(arr, 20);
        System.out.println(Arrays.toString(arr2));

        //copyOfRange:拷贝数组（指定范围）
        //细节：包头不包尾 从0到9 那就是索引0一直到索引8
        System.out.println("----------------------copyOfRange--------------------------");
        int[] arr3 = Arrays.copyOfRange(arr, 0, 9);
        System.out.println(Arrays.toString(arr3));

        //fill：填充数组
        System.out.println("----------------------fill----------------------");
        Arrays.fill(arr, 100);
        System.out.println(Arrays.toString(arr));

        //sort：排序。默认情况下，给基本数据类型进行升序排列 快速排序
        System.out.println("-----------------------sort---------------------");
        int[] arr4 = {10,8,3,2,5,2};
        Arrays.sort(arr4);
        System.out.println(Arrays.toString(arr4));

        //sort 重载的sort 按照指定的规则排序
        //参数一：要排序的数组  参数二：排序规则
        //只能给引用数据类型的数组进行排序。如果数组是基本数据类型的，需要变成其包装类
        System.out.println("-----------------------sort---------------------");
        Integer[] arr5 = {2,3,1,5,6,7,8,4,9};
        //第二个参数是一个接口，所以我们在调用方法的时候，需要传递这个接口的实现类对象，作为排序的规则
        //这个实现类，我只使用一次，所以不需要单独写一个类，直接使用匿名内部类
        //这个sort的底层原理：利用插入排序+二分查找的方式进行排序  默认把0索引的数据当作是有序的序列，1索引到最后认为是无序的
        Arrays.sort(arr5,new Comparator<Integer>() {
            @Override
            //o1：表示无序序列中，遍历得到的每一个元素
            //o2：有序序列中的元素
            //返回值：
            //负数：表示当前要插入的元素是小的，放在后面
            //正数：表示当前要插入的元素是大的，放在后面
            //0：表示当前要插入的元素跟现在的元素一样，也放后面
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(Arrays.toString(arr5));
    }
}
