package com.kkk.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private Integer tid;
    private String tname;

    private List<Student> studentList;
}
