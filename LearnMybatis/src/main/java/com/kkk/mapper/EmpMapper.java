package com.kkk.mapper;

import com.kkk.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    List<Emp> list();

    //根据姓名查询
    Emp getEmpByName(String name);
    Emp getEmpByName2(String name);

    //数据输入
    //1.单个简单类型参数
    void deleteById(Integer empId);

    //2.实体类类型参数
    void addEmp(Emp emp);

    //3.零散的简单类型数据
    List<Emp> getEmpList(@Param("empName") String empName, @Param("minSalary") Double minSalary);

    //4.Map类型的参数
    void addEmp2(Map map);

    //5.更新
    void updateEmp(Emp emp);

    //数据输入
    //1.单个简单类型
    Double getEmpSalary(Integer empId);

    //2.返回实体类对象
    Emp getEmpById(Integer empId);

    //3.返回List
    List<Double> getEmpSalaryList();

    //4.返回Map
    Map<String,Double> getMinMaxAvgSalary();

    //5.返回主键值
    void addEmp3(Emp emp);

    //6.实体类属性和数据库字段对应关系
    Emp getEmpById2(Integer empId);
}
