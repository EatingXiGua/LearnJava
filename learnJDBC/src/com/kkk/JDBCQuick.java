package com.kkk;

import java.sql.*;

public class JDBCQuick {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/atguigu";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.获取执行sql语句的对象 实际上就是一个把sql语句发送给mysql的对象
        Statement stmt = conn.createStatement();

        //4.编写sql语句，并执行，接收返回的结果集
        String sql = "select * from t_emp";
        ResultSet rs = stmt.executeQuery(sql);

        //5.处理结果，遍历rs结果集
        while (rs.next()) {
            int empId = rs.getInt("emp_id");
            String empName = rs.getString("emp_name");
            double empSalary = rs.getDouble("emp_salary");
            int empAge = rs.getInt("emp_age");
            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        //6.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
