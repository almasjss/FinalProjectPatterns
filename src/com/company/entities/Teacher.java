package com.company.entities;

import com.company.factory.TeacherFactory;
import com.company.observer.Observer;

import java.util.List;
import java.util.Map;

public class Teacher implements Observer {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Course course;

    private final Map<String, Teacher> teacherMap = TeacherFactory.getInstance().getTeachers();

    public Teacher(int id, String firstName, String lastName, String username, String password,
                   Course course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.course = course;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher[" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", course=" + course +
                "]\n";
    }

    public boolean login(String username, String password) {
        for(Map.Entry<String, Teacher> t : teacherMap.entrySet()){
            if (t.getValue().getUsername().equals(username) && t.getValue().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(List<String> subjects) {
        System.out.println("Dear, teachers!\n" + "There are updates in our course: " + subjects);
    }
}
