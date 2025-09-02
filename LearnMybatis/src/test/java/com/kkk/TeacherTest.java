package com.kkk;

import com.kkk.mapper.EmpMapper;
import com.kkk.mapper.TeacherMapper;
import com.kkk.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class TeacherTest {
    private TeacherMapper teacherMapper = null;
    SqlSession sqlSession = null;
    @BeforeEach
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }

    @Test
    public void test1(){
        teacherMapper.getTeacherList().forEach(System.out::println);
    }
    @Test
    public void test2(){
        teacherMapper.getTeacherList2().forEach(System.out::println);
    }

}
