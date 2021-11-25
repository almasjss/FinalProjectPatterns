package com.company.adapter.repo;

import com.company.entities.Course;

import java.util.List;

public interface AdminCourseAdapter {
    void addCourse(Course course);
    void deleteCourse(Course course);
    Course getCourse(int id);
    List<Course> getAllCourses();
}
