package com.advanced;

import com.advanced.pojo.Employee;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCAdvanced {
    @Test
    public void testORM() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "123456");
        PreparedStatement preparedStatement = connection.prepareStatement("select emp_id,emp_name,emp_salary,emp_age from t_emp where emp_id=?");
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();

        Employee employee = null;
        while (resultSet.next()) {
            employee = new Employee();
            int emp_id = resultSet.getInt("emp_id");
            String emp_name = resultSet.getString("emp_name");
            double emp_salary = resultSet.getDouble("emp_salary");
            int emp_age = resultSet.getInt("emp_age");
            employee.setEmpId(emp_id);
            employee.setEmpName(emp_name);
            employee.setEmpSalary(emp_salary);
            employee.setEmpAge(emp_age);
            System.out.println(employee);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testORMList() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "123456");
        PreparedStatement preparedStatement = connection.prepareStatement("select emp_id,emp_name,emp_salary,emp_age from t_emp");
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Employee> elist = new ArrayList<Employee>();

        while (resultSet.next()) {
            Employee employee = new Employee();
            int emp_id = resultSet.getInt("emp_id");
            String emp_name = resultSet.getString("emp_name");
            double emp_salary = resultSet.getDouble("emp_salary");
            int emp_age = resultSet.getInt("emp_age");
            employee.setEmpId(emp_id);
            employee.setEmpName(emp_name);
            employee.setEmpSalary(emp_salary);
            employee.setEmpAge(emp_age);
            elist.add(employee);
        }

        System.out.println(elist);
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testReturnPK() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "123456");
        //预编译sql语句，告知preparedStatement，返回新增数据的主键列的值
        String sql = "insert into t_emp(emp_name,emp_salary,emp_age) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        Employee employee = new Employee(null,"jack",10000.0,15);
        preparedStatement.setString(1, employee.getEmpName());
        preparedStatement.setDouble(2, employee.getEmpSalary());
        preparedStatement.setInt(3, employee.getEmpAge());
        int result = preparedStatement.executeUpdate();
        ResultSet resultSet = null;
        if(result > 0){
            System.out.println("成功");
            //获取当前新增数据的主键，回显到Java中employee对象的empId属性上
            //返回的主键值，是一个单行单列的结果存储到ResultSet中
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                employee.setEmpId(id);
            }
            System.out.println(employee);
        } else {
            System.out.println("失败");
        }
        if (resultSet != null) {
            resultSet.close();
        }
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testBatch() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu?rewriteBatchedStatements=true", "root", "123456");

        /**
         * 编写sql语句
         * 1.必须在连接数据库的URL后面追加?rewriteBatchedStatements=true，允许批量操作
         * 2.新增SQL必须用values。且语句最后不要追加;结束
         * 3.调用addBatch()方法，将SQL语句进行批量添加操作
         * 4.统一执行批量操作，调用executeBatch()
         */

        String sql = "insert into t_emp(emp_name,emp_salary,emp_age) values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setDouble(2, 10000.0+i);
            preparedStatement.setInt(3, i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

        long end = System.currentTimeMillis();
        System.out.println("消耗时间：" + (end - start) + "ms");
        preparedStatement.close();
        connection.close();
    }
}
