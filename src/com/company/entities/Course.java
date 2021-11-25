package com.company.entities;

import com.company.observer.Observable;
import com.company.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Course implements Observable {
    private int courseId;
    private String courseName;
    private String courseDescription;

    private final List<Observer> observers = new ArrayList<>();
    private final List<String> subjects = new ArrayList<>();

    public Course(int courseId, String courseName, String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "Course[" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                "]\n";
    }

    public List<String> getSubjects() {
        return subjects;
    }

    @Override
    public void addSubject(String subject) {
        subjects.add(subject);
        notifyObservers();
    }

    @Override
    public void removeSubject(String subject) {
        subjects.remove(subject);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(subjects);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
