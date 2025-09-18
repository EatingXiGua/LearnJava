package com.kkk.springbootcondition.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class ClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        //1.需求：导入jedis坐标后创建bean
//        //判断redis.clients.jedis.Jedis.class文件是否存在
//        boolean flag = true;
//        try {
//            Class<?> cls = Class.forName("redis.clients.jedis.Jedis");
//        } catch (ClassNotFoundException e) {
//            flag = false;
//        }
//        return flag;
        //2.需求：导入通过注解属性值value指定坐标后创建bean
        //获取注解属性值
        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        //System.out.println(map);
        String[] value = (String[]) map.get("value");
        boolean flag = true;
        try {
            for (String className : value) {
                Class<?> cls = Class.forName(className);
            }

        } catch (ClassNotFoundException e) {
            flag = false;
        }
        return flag;
    }
}
