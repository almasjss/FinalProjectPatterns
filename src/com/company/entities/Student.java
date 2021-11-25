package com.company.entities;

import com.company.factory.StudentFactory;
import com.company.observer.Observer;

import java.util.List;
import java.util.Map;

public class Student implements Observer {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String program;
    private int year;

    private final Map<String, Student> studentMap = StudentFactory.getInstance().getStudents();

    public Student(int id, String firstName, String lastName, String username, String password,
                   String program, int year) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.program = program;
        this.year = year;
    }

    public Student() {
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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student[" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", program='" + program + '\'' +
                ", year=" + year +
                "]\n";
    }

    public boolean login(String username, String password) {
        for(Map.Entry<String, Student> s : studentMap.entrySet()){
            if (s.getValue().getUsername().equals(username) && s.getValue().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(List<String> subjects) {
        System.out.println("Dear, students!\n" + "There are updates in our course: " + subjects);
    }
}
