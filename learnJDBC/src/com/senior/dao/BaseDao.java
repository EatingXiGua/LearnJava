package com.senior.dao;

import com.senior.JDBCUtilV2;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {

    //通用的增删改方法
    public int executeUpdate(String sql,Object... params) throws Exception {
        Connection connection = JDBCUtilV2.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
        int row = preparedStatement.executeUpdate();
        preparedStatement.close();
        JDBCUtilV2.release();
        return row;
    }

    //通用的查询方法
    public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws Exception {
        Connection connection = JDBCUtilV2.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        //获取结果集中的元数据对象 包含了列的数量、每个列的名称
        ResultSetMetaData metaData = resultSet.getMetaData();
        List<T> list = new ArrayList<T>();
        while (resultSet.next()) {
            //循环一次，代表有一行数据，通过反射创建一个对象
            T t = clazz.newInstance();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //通过下标获取列值
                Object value = resultSet.getObject(i);//对于Employee 是empId、empName、empSalary、empAge的值
                //拿到当前列的名字 对象的属性名在数据库中对应的那个名字
                String columnName = metaData.getColumnName(i);//对于Employee 是emp_id、emp_name、emp_salary、emp_age
                //获取类T的属性
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                //赋值 给对象t的field属性赋值value
                field.set(t, value);
            }
            list.add(t);
        }
        resultSet.close();
        preparedStatement.close();
        JDBCUtilV2.release();
        return list;
    }

    //获取查询结果的第一个
    public <T> T executeQueryBean(Class<T> clazz, String sql, Object... params) throws Exception{
        List<T> list = this.executeQuery(clazz, sql, params);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }






}
