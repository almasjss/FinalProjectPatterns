package com.company.factory;

import com.company.entities.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentFactory {
    private static StudentFactory instance;
    private final Map<String, Student> students = new HashMap<>();

    private StudentFactory() {
    }

    public static StudentFactory getInstance() {
        if( instance == null) {
            instance = new StudentFactory();
        }
        return instance;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public void addDefaultStudents() {
        StudentFactory.getInstance().addStudent
                (1, "John", "Wick", "john_wick", "Qwerty123",
                        "SE", 1);
        StudentFactory.getInstance().addStudent
                (2, "John", "Snow", "john_snow", "Qwerty123",
                        "IA", 2);
        StudentFactory.getInstance().addStudent
                (3, "Al", "Capone", "al_capone", "Qwerty123",
                        "IT", 2);
        StudentFactory.getInstance().addStudent
                (4, "Tony", "Stark", "tony_stark",
                        "Qwerty123", "MT", 3);
        StudentFactory.getInstance().addStudent
                (5, "Bruce", "Wayne", "bruce_wayne", "Qwerty123",
                        "CS", 1);
    }

    public Student addStudent(int id, String firstName, String lastName, String username,
                              String password, String program, int year) {
        Student student = new Student(id, firstName, lastName, username, password, program, year);
        students.put(username, student);
        return student;
    }
}
