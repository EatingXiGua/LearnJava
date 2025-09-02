package com.kkk.mapper;

import com.kkk.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> list();

    //根据姓名查询
    Emp getEmpByName(String name);
    Emp getEmpByName2(String name);
}
