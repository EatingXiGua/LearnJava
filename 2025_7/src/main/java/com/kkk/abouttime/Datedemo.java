package com.kkk.abouttime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datedemo {

    public static void main(String[] args) throws ParseException {
        //1、Date类
        //空参构造 默认就是当前时间
        Date date = new Date();
        System.out.println(date);
        //有参构造 从时间原点1970年1月1日8时0分0秒 加 0秒
        Date date1 = new Date(0L);
        System.out.println(date1);
        //setTime 修改时间 再加1000毫秒
        date1.setTime(1000L);
        System.out.println(date1);
        //getTime 获取当前时间的毫秒值
        System.out.println(date1.getTime());

        //2、SimpleDateFormat类
        //空参构造创建SimpleDateFormat对象，默认格式
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d = new Date(1000L);
        String str = sdf.format(d);
        System.out.println(str);//1970/1/1 上午8:00
        //带参构造创建SimpleDateFormat对象，指定格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = sdf1.format(d);
        System.out.println(str1);//1970-01-01 08:00:01

        //parse 字符串->Date对象
        String s = "2025-11-11 11:11:11";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = sdf2.parse(s);
        System.out.println(date2);

        //3、Calendar类
        //静态方法获取日历对象
        //底层原理：会根据系统的不同时区来获取不同的日历对象
        //会把时间中的纪元、年、月、日、时、分、秒、星期 等等都放在一个数组中
        //细节：月份显示0~11 星期1~7，1是星期天，2是星期一
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        //修改日历代表的时间
        Date d1 = new Date(0L);
        calendar.setTime(d1);
        System.out.println(calendar);
        //获取年份
        int i = calendar.get(Calendar.YEAR);
        System.out.println(i);
        //修改年分
        calendar.set(Calendar.YEAR, 2015);
        System.out.println(calendar.get(Calendar.YEAR));
        //年份增加10年
        calendar.add(Calendar.YEAR,10);
        System.out.println(calendar.get(Calendar.YEAR));
    }
}
