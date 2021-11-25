package com.company.panels;

import com.company.adapter.AdminCourse;
import com.company.entities.Course;
import com.company.entities.Student;
import com.company.factory.CourseFactory;
import com.company.observer.Observer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentPanel {

    private final Student student;

    AdminCourse adminCourse = new AdminCourse(new Course());

    private final List<Course> studentCourses = new ArrayList<>();
    private final List<String> subjects = new ArrayList<>();

    public StudentPanel(Student student) {
        this.student = student;
    }

    Scanner scanner = new Scanner(System.in);

    public void studentPage() {
        addStudentCourses();
        while (true) {
            System.out.println("Hello, " + student.getFirstName() + ' ' + student.getLastName() + "!");
            System.out.println(student.toString());
            System.out.println("What are you going to do?");
            System.out.println("Choose by number your action:");
            System.out.println("1. Get Courses");
            System.out.println("2. Get Notifications");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getStudentCourses();
                } else if (option == 2) {
                    getCourseNotifications();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addStudentCourses() {
        List<Course> courses = CourseFactory.getInstance().getCourses();
        for (int i = 0; i < courses.size(); i++)  {
            List<Observer> observers = adminCourse.getAllCourses().get(i).getObservers();
            if (observers.contains(student)) {
                studentCourses.add(adminCourse.getAllCourses().get(i));
            }
        }
    }

    public void getStudentCourses() {
        if (studentCourses.isEmpty()) {
            System.out.println(student.getFirstName() + ' ' + student.getLastName() +
                    " does not have the courses");
        } else {
            for (Course studentCourse : studentCourses) {
                System.out.println(studentCourse.toString());
            }
        }
    }

    public void getCourseNotifications() {
        System.out.println("Enter Course ID: ");
        int courseId = scanner.nextInt();
        for (Course studentCourse : studentCourses) {
            if (courseId == studentCourse.getCourseId()) {
                Course course = adminCourse.getCourse(courseId - 1);
                subjects.addAll(course.getSubjects());
            }
        }
        if (subjects.isEmpty()) {
            System.out.println("There is no information by this course");
        } else {
            for (String subject : subjects) {
                System.out.println(subject);
            }
        }
        subjects.clear();
    }
}
