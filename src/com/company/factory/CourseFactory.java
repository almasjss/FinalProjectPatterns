package com.company.factory;

import com.company.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseFactory {
    private static CourseFactory instance;
    private final List<Course> courses = new ArrayList<>();

    private CourseFactory() {
    }

    public static CourseFactory getInstance() {
        if (instance == null) {
            instance = new CourseFactory();
        }
        return instance;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addDefaultCourse(){
        CourseFactory.getInstance().addCourse
                (1,"ADS","Algorithm Data Structures Java");
        CourseFactory.getInstance().addCourse
                (2,"OOP","Object Oriented Programming Java");
        CourseFactory.getInstance().addCourse
                (3,"Base Coding"," Basic Knowledge Coding C++");
        CourseFactory.getInstance().addCourse
                (4,"Web Dev","Web Development PHP,JS");
        CourseFactory.getInstance().addCourse
                (5,"Mobile Dev","Android Development Java");
    }

    public Course addCourse(int courseId, String courseName, String courseDescription) {
        Course course = new Course(courseId, courseName, courseDescription);
        courses.add(course);
        return course;
    }
}
