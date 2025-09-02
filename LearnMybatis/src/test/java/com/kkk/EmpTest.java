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
import java.util.List;
import java.util.Map;

public class EmpTest {

    private EmpMapper empMapper = null;
    SqlSession sqlSession = null;
    @BeforeEach
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
    }

    @Test
    public void test()   {
        empMapper.list().forEach(System.out::println);
    }

    @Test
    public void test1()  {
        Emp tom = empMapper.getEmpByName("tom");
        System.out.println(tom);
        Emp tom2 = empMapper.getEmpByName2("tom");
        System.out.println(tom2);
    }

    @Test
    public void test2() {
        empMapper.deleteById(100);
    }

    @Test
    public void test3() {
        Emp lili = new Emp();
        lili.setEmpName("lili");
        lili.setEmpSalary(123.0);
        empMapper.addEmp(lili);
        sqlSession.commit();
    }

    @Test
    public void test4() {
        List<Emp> empList = empMapper.getEmpList("j", 5.0);
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    public void test5() {
        Map map = Map.of("empName","zhangsan","empSalary",123.0);
        empMapper.addEmp2(map);
        sqlSession.commit();
    }

    @Test
    public void test6() {
        Double empSalary = empMapper.getEmpSalary(1);
        System.out.println(empSalary);
    }

    @Test
    public void test7() {
        Emp emp = empMapper.getEmpById(1);
        System.out.println(emp);
    }

    @Test
    public void test8() {
        empMapper.getEmpSalaryList().forEach(System.out::println);
    }

    @Test
    public void test9() {
        Map<String, Double> minMaxAvgSalary = empMapper.getMinMaxAvgSalary();
        minMaxAvgSalary.entrySet().forEach(System.out::println);
    }

    @Test
    public void test10() {
        Emp emp = new Emp();
        emp.setEmpName("lisi");
        emp.setEmpSalary(4000.0);
        empMapper.addEmp3(emp);
        System.out.println(emp);
        sqlSession.commit();
    }

    @Test
    public void test11() {
        Emp emp = empMapper.getEmpById2(1);
        System.out.println(emp);
    }

    @Test
    public void test12() {
        Emp emp = empMapper.getEmpById2(1);
        emp.setEmpSalary(500.21);
        empMapper.updateEmp(emp);
        sqlSession.commit();
    }
}
