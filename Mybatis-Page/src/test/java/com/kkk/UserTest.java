package com.kkk;

import com.github.pagehelper.PageInfo;
import com.kkk.mapper.UserMapper;
import com.kkk.pojo.User;
import com.kkk.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.findAll().forEach(System.out::println);
    }

    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserService service = new UserService(mapper);

        PageInfo<User> page = service.getUserPage(2, 7);

        System.out.println("总数: " + page.getTotal());
        System.out.println("总页数: " + page.getPages());
        System.out.println("第 " + page.getPageNum() + " 页, 每页 " + page.getPageSize() + " 条");
        page.getList().forEach(System.out::println);

        sqlSession.close();
    }
}
