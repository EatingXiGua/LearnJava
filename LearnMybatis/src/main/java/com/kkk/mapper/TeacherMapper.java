package com.kkk.mapper;

import com.kkk.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    //查询teacher列表，每一个元素就是Teacher本身
    List<Teacher> getTeacherList();

    //查询teacher列表，每一个元素就是Teacher本身，然后每一个Teacher都自带一个学员List
    List<Teacher> getTeacherList2();
}
