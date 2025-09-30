package com.kkk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkk.mapper.UserMapper;
import com.kkk.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public PageInfo<User> getUserPage(int pageNum, int pageSize) {
        // 设置分页参数（下一条查询会自动带 limit）
        PageHelper.startPage(pageNum, pageSize);

        // 执行查询
        List<User> users = userMapper.findAll();

        // 封装成 PageInfo（包含总数、总页数、当前页数据等）
        return new PageInfo<>(users);
    }
}
