package com.company.factory;

import com.company.entities.Course;
import com.company.entities.Teacher;

import java.util.HashMap;
import java.util.Map;

public final class TeacherFactory {
    private static TeacherFactory instance;
    private final Map<String, Teacher> teachers = new HashMap<>();

    private TeacherFactory() {
    }

    public static TeacherFactory getInstance() {
        if( instance == null) {
            instance = new TeacherFactory();
        }
        return instance;
    }

    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public void addDefaultTeachers() {
        TeacherFactory.getInstance().addTeacher
                (1,"Almas","Nurakhmetov","almasjss","Qwerty123",
                        CourseFactory.getInstance().getCourses().get(1));
        TeacherFactory.getInstance().addTeacher
                (2,"Zhandos","Kayrat","zhandos02","Qwerty123",
                        CourseFactory.getInstance().getCourses().get(1));
        TeacherFactory.getInstance().addTeacher
                (3,"Arman","Suleimenov","arman02","Qwerty123",
                        CourseFactory.getInstance().getCourses().get(3));
        TeacherFactory.getInstance().addTeacher
                (4,"Karim","Masimov","karim02","Qwertvy123",
                        CourseFactory.getInstance().getCourses().get(3));
        TeacherFactory.getInstance().addTeacher
                (5,"Islam","Makhchev","islam02","Qwerty123",
                        CourseFactory.getInstance().getCourses().get(2));
    }

    public Teacher addTeacher(int id, String firstName, String lastName, String username, String password,
                              Course course) {
        Teacher teacher = new Teacher(id, firstName, lastName, username, password, course);
        teachers.put(username, teacher);
        return teacher;
    }
}
