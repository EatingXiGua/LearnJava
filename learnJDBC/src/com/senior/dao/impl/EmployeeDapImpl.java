package com.senior.dao.impl;

import com.advanced.pojo.Employee;
import com.senior.dao.EmployeeDao;

import java.util.List;
import com.senior.dao.BaseDao;

public class EmployeeDapImpl extends BaseDao implements EmployeeDao {
    @Override
    public List<Employee> selectAll() {
        //注册驱动
        //获取连接
        //预编译sql语句
        //为占位符赋值，执行sql，接收结果
        //处理结果
        //释放资源

        try {
            String sql = "select emp_id empId,emp_name empName,emp_salary empSalary,emp_age empAge from t_emp";
            return executeQuery(Employee.class,sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee selectByEmpId(Integer empId) {
        try {
            String sql = "select emp_id empId,emp_name empName,emp_salary empSalary,emp_age empAge from t_emp where emp_id = ?";
            return executeQueryBean(Employee.class,sql,empId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(Employee employee) {
        try {
            String sql = "insert into t_emp(emp_name,emp_salary,emp_age) values (?,?,?)";
            return executeUpdate(sql,employee.getEmpName(),employee.getEmpSalary(),employee.getEmpAge());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Employee employee) {
        try {
            String sql = "update t_emp set emp_salary = ? where emp_id = ?";
            return executeUpdate(sql,employee.getEmpSalary(),employee.getEmpId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(Integer empId) {
        try {
            String sql = "delete from t_emp where emp_id = ?";
            return executeUpdate(sql,empId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
