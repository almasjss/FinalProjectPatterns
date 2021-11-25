package com.company.adapter.repo;

import com.company.entities.Student;

import java.util.Map;

public interface AdminStudentAdapter {
    void addStudent(Student student);
    void deleteStudent(Student student);
    Student getStudent(String username);
    Map<String, Student> getAllStudents();
}
