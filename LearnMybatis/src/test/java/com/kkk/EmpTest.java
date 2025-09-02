package com.kkk;

import com.kkk.mapper.EmpMapper;
import com.kkk.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class EmpTest {

    private EmpMapper empMapper = null;
    @BeforeEach
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
    }

    @Test
    public void test() throws IOException {
        empMapper.list().forEach(System.out::println);
    }

    @Test
    public void test1() throws IOException {
        Emp tom = empMapper.getEmpByName("tom");
        System.out.println(tom);
        Emp tom2 = empMapper.getEmpByName2("tom");
        System.out.println(tom2);
    }
}
