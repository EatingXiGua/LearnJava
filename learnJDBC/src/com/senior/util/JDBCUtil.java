package com.senior.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 * 1.维护一个连接池对象
 * 2.对外提供在连接池中获取连接的方法
 * 3.对外提供回收连接的方法
 *
 * 工具类仅对外提供共性的功能代码，所有方法均为静态方法
 */
public class JDBCUtil {
    //创建连接池引用，因为要提供给当前项目的全局使用，所以创建为静态
    private static DataSource dataSource;

    //在项目启动时，即创建连接池对象，赋值给dataSource
    static {
        try{
            Properties prop = new Properties();
            InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void release(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
