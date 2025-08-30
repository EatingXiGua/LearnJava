package com.senior;

import com.senior.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilTest {
    @Test
    public void testJDBCUtil() {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
        JDBCUtil.release(connection);
        System.out.println(connection);
    }

    @Test
    public void testJDBCUtilV2() {
        //获取的是三个不同的Connection对象
        Connection connection1 = JDBCUtil.getConnection();
        System.out.println(connection1);
        Connection connection2 = JDBCUtil.getConnection();
        System.out.println(connection2);
        Connection connection3 = JDBCUtil.getConnection();
        System.out.println(connection3);

        //获取的是三个相同的Connection对象
        Connection connection4 = JDBCUtilV2.getConnection();
        System.out.println(connection4);
        Connection connection5 = JDBCUtilV2.getConnection();
        System.out.println(connection5);
        Connection connection6 = JDBCUtilV2.getConnection();
        System.out.println(connection6);

    }
}
