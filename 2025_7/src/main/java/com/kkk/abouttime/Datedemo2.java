package com.kkk.abouttime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Datedemo2 {
    public static void main(String[] args) {
        //1、ZoneId时区
        //获取所有时区名称
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);
        //获取当前系统默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        //获取指定时区
        ZoneId zoneId1 = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId1);

        //2、Instant时间戳
        //获取当前时间的Instant对象（标准时间）
        Instant now = Instant.now();
        System.out.println(now);
        //根据时间数值获取Instant对象
        Instant i1 = Instant.ofEpochMilli(0L);
        System.out.println(i1);
        //指定时区
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(time);
        //isXXX
        Instant i2 = Instant.ofEpochMilli(0L);
        Instant i3 = Instant.ofEpochMilli(1000L);
        boolean r = i2.isBefore(i3);
        System.out.println(r);
        //加时间
        Instant i4 = i2.plusSeconds(10000000000L);
        System.out.println(i4);

        //3、ZoneDateTime带时区的时间
        //获取当前时间对象
        ZonedDateTime z1 = ZonedDateTime.now();
        System.out.println(z1);
        //获取指定的时间对象
        ZonedDateTime z2 = ZonedDateTime.of(2025,7,27,1,10,0,0,ZoneId.of("Asia/Shanghai"));
        System.out.println(z2);
        //Instant对象 + 时区 组成ZoneDateTime对象
        Instant i5 = Instant.ofEpochMilli(0L);
        ZoneId z3 = ZoneId.of("Asia/Shanghai");
        ZonedDateTime z4 = ZonedDateTime.ofInstant(i5, z3);
        System.out.println(z4);
        //withXXX 修改时间
        ZonedDateTime z5 = z4.withYear(2000);
        System.out.println(z5);
        //减少时间
        ZonedDateTime z6 = z5.minusYears(1);
        System.out.println(z6);
        //增加时间
        ZonedDateTime z7 = z6.plusYears(1);
        System.out.println(z7);

        //4、DateTimeFormatter用于时间的格式化和解析
        //获取时间对象
        ZonedDateTime time1 = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        //解析/格式化器
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //格式化
        System.out.println(dtf1.format(time1));
    }
}
