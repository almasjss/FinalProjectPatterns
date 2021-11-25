package com.company.adapter;

import com.company.adapter.repo.AdminCourseAdapter;
import com.company.entities.Course;
import com.company.factory.CourseFactory;

import java.util.List;

public class AdminCourse implements AdminCourseAdapter {
    private final Course course;

    public AdminCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public void addCourse(Course course) {
        CourseFactory.getInstance().addCourse(course.getCourseId(), course.getCourseName(),
                course.getCourseDescription());
    }

    @Override
    public void deleteCourse(Course course) {
        CourseFactory.getInstance().getCourses().remove(course);
    }


    @Override
    public Course getCourse(int id) {
        return CourseFactory.getInstance().getCourses().get(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return CourseFactory.getInstance().getCourses();
    }
}
