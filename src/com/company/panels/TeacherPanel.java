package com.company.panels;

import com.company.adapter.AdminCourse;
import com.company.entities.Course;
import com.company.entities.Teacher;
import com.company.factory.CourseFactory;
import com.company.observer.Observer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TeacherPanel {
    AdminCourse adminCourse = new AdminCourse(new Course());

    private final Teacher teacher;

    private final List<Course> teacherCourses = new ArrayList<>();
    private final List<String> subjects = new ArrayList<>();

    public TeacherPanel(Teacher teacher) {
        this.teacher = teacher;
    }

    Scanner scanner = new Scanner(System.in);

    public void teacherPanel() {
        addTeacherCourses();
        while (true) {
            System.out.println("Hello, " + teacher.getFirstName() + ' ' + teacher.getLastName() + "!");
            System.out.println(teacher.toString());
            System.out.println("What are you going to do?");
            System.out.println("Choose by number your action:");
            System.out.println("1. Get Courses");
            System.out.println("2. Get Notifications");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getTeacherCourses();
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

    public void addTeacherCourses() {
        List<Course> courses = CourseFactory.getInstance().getCourses();
        for (int i = 0; i < courses.size(); i++)  {
            List<Observer> observers = adminCourse.getAllCourses().get(i).getObservers();
            if (observers.contains(teacher)) {
                teacherCourses.add(adminCourse.getAllCourses().get(i));
            }
        }
    }

    public void getTeacherCourses() {
        if (teacherCourses.isEmpty()) {
            System.out.println(teacher.getFirstName() + ' ' + teacher.getLastName() +
                    " does not have the courses");
        } else {
            for (Course teacherCourse : teacherCourses) {
                System.out.println(teacherCourse.toString());
            }
        }
    }

    public void getCourseNotifications() {
        System.out.println("Enter Course ID: ");
        int courseId = scanner.nextInt();
        for (Course teacherCourse : teacherCourses) {
            if (courseId == teacherCourse.getCourseId()) {
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
