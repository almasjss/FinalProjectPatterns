package com.company.adapter;

import com.company.adapter.repo.AdminTeacherAdapter;
import com.company.entities.Teacher;
import com.company.factory.TeacherFactory;

import java.util.Map;

public class AdminTeacher implements AdminTeacherAdapter {
    private final Teacher teacher;

    public AdminTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        TeacherFactory.getInstance().addTeacher(teacher.getId(), teacher.getFirstName(),
                teacher.getLastName(), teacher.getUsername(), teacher.getPassword(), teacher.getCourse());
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        TeacherFactory.getInstance().getTeachers().remove(teacher.getUsername());
    }

    @Override
    public Teacher getTeacher(String username) {
        return TeacherFactory.getInstance().getTeachers().get(username);
    }

    @Override
    public Map<String, Teacher> getAllTeachers() {
        return TeacherFactory.getInstance().getTeachers();
    }
}
