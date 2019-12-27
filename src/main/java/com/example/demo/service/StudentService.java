package com.example.demo.service;

import com.example.demo.mapper.StudentDao;
import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {


    @Resource
    private StudentDao studentDao;

    public Student getStudentById(int id) {

        return studentDao.getStudentInfoById(id);
    }

    public List<Student> getStudentListService() {
        return studentDao.getStudentList();
    }

    public void delStudentByIdService(int id) {
        studentDao.delStudentById(id);
    }

    public void addStudentService(String name, int age, String desc) {
        studentDao.addStudent(name, age, desc);
    }

    public int getMaxIdService() {
        return studentDao.getMaxId();
    }

    public void updateStudentByIdService(int id, String name, int age, String desc) {
        studentDao.updateStudentById(id, name, age, desc);
    }

    public List<Student> searchServie(String name, String age, String desc) {

        return studentDao.search(name, age, desc);
    }


}
