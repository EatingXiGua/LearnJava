package com.senior.dao;

import com.advanced.pojo.Employee;

import java.util.List;

public interface EmployeeDao {

    //查所有
    List<Employee> selectAll();

    //查一个
    Employee selectByEmpId(Integer empId);

    //插入
    int insert(Employee employee);

    //修改
    int update(Employee employee);

    //删除
    int delete(Integer empId);
}
