package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    Student getStudentInfoById(@Param("id") int id);

    List<Student> getStudentList();

    void delStudentById(@Param("id") int id);

    void addStudent(@Param("name") String name, @Param("age") int age, @Param("desc") String desc);

    int getMaxId();

    void updateStudentById(@Param("id") int id, @Param("name") String name, @Param("age") int age, @Param("desc") String desc);

    List<Student> search(@Param("name") String name, @Param("age") String age, @Param("desc") String desc);
}