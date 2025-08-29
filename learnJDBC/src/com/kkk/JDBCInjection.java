package com.kkk;

import java.sql.*;
import java.util.Scanner;

public class JDBCInjection {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动 省略

        //2.获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu","root","123456");

        //3.获取执行sql语句对象
        Statement statement = conn.createStatement();
        System.out.println("请输入员工姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        //4.编写sql语句 并执行
        String sql = "select * from t_emp where emp_name = '" + name + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        //5.处理结果
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        //6.释放资源
        resultSet.close();
        statement.close();
        conn.close();
    }
}
