package com.advanced.pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {
    @Test
    public void testDruid() throws Exception {
        //1.创建Properties集合，用于存储外部配置文件的key和value值
        Properties props = new Properties();

        //2.读取外部配置文件，获取输入流，加载到Properties集合
        InputStream inputStream = DruidTest.class.getClassLoader().getResourceAsStream("db.properties");
        props.load(inputStream);

        //3.基于Properties集合构建DruidDataSource连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(props);

        //4.通过连接池获取连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //5.CRUD

        //6.回收连接
        connection.close();
    }
}
