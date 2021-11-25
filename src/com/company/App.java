package com.company;

import com.company.entities.Admin;
import com.company.entities.Student;
import com.company.entities.Teacher;
import com.company.factory.CourseFactory;
import com.company.factory.StudentFactory;
import com.company.factory.TeacherFactory;
import com.company.observer.Observable;
import com.company.observer.Observer;
import com.company.panels.AdminPanel;
import com.company.panels.StudentPanel;
import com.company.panels.TeacherPanel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    Teacher teacher = new Teacher();
    Student student = new Student();

    AdminPanel adminPanel = new AdminPanel();

    Scanner scanner = new Scanner(System.in);

    public void start() {
        addDefaultValues();
        addDefault();
        while (true) {
            System.out.println("Welcome to Moodlee!");
            System.out.println("Login Panel");
            System.out.println("Enter your username");
            String username = scanner.next();
            System.out.println("Enter your password");
            String password = scanner.next();
            System.out.println("Choose number by your occupation");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Admin");
            try {
                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                if (option == 1 &&  student.login(username, password)) {
                    Student s = StudentFactory.getInstance().getStudents().get(username);
                    StudentPanel studentPanel = new StudentPanel(s);
                    studentPanel.studentPage();
                } else if (option == 2 && teacher.login(username, password)) {
                    Teacher t = TeacherFactory.getInstance().getTeachers().get(username);
                    TeacherPanel teacherPanel = new TeacherPanel(t);
                    teacherPanel.teacherPanel();
                } else if (option == 3 && Admin.getInstance().login(username, password)) {
                    adminPanel.adminPage();
                } else {
                    start();
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addDefaultValues() {
        CourseFactory.getInstance().addDefaultCourse();
        TeacherFactory.getInstance().addDefaultTeachers();
        StudentFactory.getInstance().addDefaultStudents();
    }

    public void addDefault() {
        Observer studentObserver = StudentFactory.getInstance().getStudents().get("tony_stark");
        Observer teacherObserver = TeacherFactory.getInstance().getTeachers().get("almasjss");
        Observable course1 = CourseFactory.getInstance().getCourses().get(0);
        Observable course2 = CourseFactory.getInstance().getCourses().get(1);
        Observable course3 = CourseFactory.getInstance().getCourses().get(2);
        Observable course4 = CourseFactory.getInstance().getCourses().get(3);
        Observable course5 = CourseFactory.getInstance().getCourses().get(4);
        course1.addObserver(studentObserver);
        course2.addObserver(studentObserver);
        course3.addObserver(studentObserver);
        course4.addObserver(studentObserver);
        course5.addObserver(studentObserver);
        course1.addObserver(teacherObserver);
        course2.addObserver(teacherObserver);
        course3.addObserver(teacherObserver);
        course4.addObserver(teacherObserver);
        course5.addObserver(teacherObserver);
        course1.addSubject("Hello, World!");
        course1.addSubject("Hello, World! 2.0");
        course2.addSubject("Welcome to OOP");
    }
}
