package com.kkk.mapper;

import com.kkk.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    @Select("SELECT * FROM t_user")
    List<User> selectAll();
}
