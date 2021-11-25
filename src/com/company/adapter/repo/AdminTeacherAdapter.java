package com.company.adapter.repo;

import com.company.entities.Teacher;

import java.util.Map;

public interface AdminTeacherAdapter {
    void addTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    Teacher getTeacher(String username);
    Map<String, Teacher> getAllTeachers();
}
