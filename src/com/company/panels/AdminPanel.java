package com.company.panels;

import com.company.adapter.AdminCourse;
import com.company.adapter.AdminStudent;
import com.company.adapter.AdminTeacher;
import com.company.entities.Course;
import com.company.entities.Student;
import com.company.entities.Teacher;
import com.company.factory.CourseFactory;
import com.company.factory.StudentFactory;
import com.company.factory.TeacherFactory;
import com.company.observer.Observable;
import com.company.observer.Observer;

import java.util.*;

public class AdminPanel {

    AdminStudent adminStudent = new AdminStudent(new Student());
    AdminTeacher adminTeacher = new AdminTeacher(new Teacher());
    AdminCourse adminCourse = new AdminCourse(new Course());
    Scanner scanner = new Scanner(System.in);

    public void adminPage() {
        while (true) {
            System.out.println("Hello, Admin!");
            System.out.println("What are you going to do?");
            System.out.println("Choose by number your action:");
            System.out.println("1. Add Course");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Student");
            System.out.println("4. Get Course");
            System.out.println("5. Get Teacher");
            System.out.println("6. Get Student");
            System.out.println("7. Remove Course");
            System.out.println("8. Remove Teacher");
            System.out.println("9. Remove Student");
            System.out.println("10. Get All Courses");
            System.out.println("11. Get All Teachers");
            System.out.println("12. Get All Students");
            System.out.println("13. Add Student to the Course");
            System.out.println("14. Add Teacher to the Course");
            System.out.println("15. Remove Student from the Course");
            System.out.println("16. Remove Teacher from the Course");
            System.out.println("17. Add Course Information");
            System.out.println("18. Remove Course Information");
            System.out.println("19. Notify All Observers");
            System.out.println("20. Get All Information By Course");
            System.out.println("21. Get All Observers By Course");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    addCourse();
                } else if (option == 2) {
                    addTeacher();
                } else if (option == 3) {
                    addStudent();
                } else if (option == 4) {
                    getCourse();
                } else if (option == 5) {
                    getTeacher();
                } else if (option == 6) {
                    getStudent();
                } else if (option == 7) {
                    deleteCourse();
                } else if (option == 8) {
                    deleteTeacher();
                } else if (option == 9) {
                    deleteStudent();
                } else if (option == 10) {
                    getAllCourses();
                } else if (option == 11) {
                    getAllTeachers();
                } else if (option == 12) {
                    getAllStudents();
                } else if (option == 13) {
                    addStudentToCourse();
                } else if (option == 14) {
                    addTeacherToCourse();
                } else if (option == 15) {
                    removeStudentFromCourse();
                } else if (option == 16) {
                    removeTeacherFromCourse();
                } else if (option == 17) {
                    addCourseInfo();
                } else if (option == 18) {
                    removeCourseInfo();
                } else if (option == 19) {
                    notifyAllObservers();
                } else if (option == 20) {
                    getAllInformation();
                } else if (option == 21) {
                    getAllObservers();
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

    public void addCourse() {
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Course Name");
        String courseName = scanner.nextLine();
        System.out.println("Enter Course Description");
        String courseDescription = scanner.nextLine();
        Observable addingCourse = CourseFactory.getInstance().
                addCourse(courseId, courseName, courseDescription);
        System.out.println(((Course) addingCourse).getCourseName() + " was added");
    }

    public void addStudent() {
        System.out.println("Enter Student ID");
        int studentId = scanner.nextInt();
        System.out.println("Enter Student First Name");
        String firstName = scanner.next();
        System.out.println("Enter Student Last Name");
        String lastName = scanner.next();
        System.out.println("Enter Student Username");
        String username = scanner.next();
        System.out.println("Enter Student password");
        String password = scanner.next();
        System.out.println("Enter Student Educational Program");
        String program = scanner.next();
        System.out.println("Enter Student Year");
        int year = scanner.nextInt();
        Observer addingStudent = StudentFactory.getInstance().
                addStudent(studentId, firstName, lastName, username, password, program, year);
        System.out.println(((Student) addingStudent).getFirstName() + ' ' +
                ((Student) addingStudent).getLastName() + " was added");
    }

    public void addTeacher() {
        System.out.println("Enter Teacher ID");
        int teacherId = scanner.nextInt();
        System.out.println("Enter Teacher First Name");
        String firstName = scanner.next();
        System.out.println("Enter Teacher Last Name");
        String lastName = scanner.next();
        System.out.println("Enter Teacher Username");
        String username = scanner.next();
        System.out.println("Enter Teacher password");
        String password = scanner.next();
        System.out.println("Enter Teacher's Course ID");
        int courseId = scanner.nextInt();
        Course course = getTeacherCourse(courseId);
        Observer addingTeacher = TeacherFactory.getInstance().
                addTeacher(teacherId, firstName, lastName, username, password, course);
        System.out.println(((Teacher) addingTeacher).getFirstName() + ' ' +
                ((Teacher) addingTeacher).getLastName() + " was added");
    }

    public Course getTeacherCourse(int courseId) {
        return adminCourse.getCourse(courseId);
    }

    public void getCourse() {
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Course currentCourse = adminCourse.getCourse(courseId - 1);
        System.out.println(currentCourse.toString());
    }

    public void getStudent() {
        System.out.println("Enter Student username");
        String username = scanner.next();
        Student currentStudent = adminStudent.getStudent(username);
        System.out.println(currentStudent.toString());
    }

    public void getTeacher() {
        System.out.println("Enter Teacher username");
        String username = scanner.next();
        Teacher currentTeacher = adminTeacher.getTeacher(username);
        System.out.println(currentTeacher.toString());
    }

    public void getAllCourses() {
        System.out.println("COURSES");
        List<Course> courses = adminCourse.getAllCourses();
        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }

    public void getAllTeachers() {
        System.out.println("TEACHERS");
        Map<String, Teacher> teachers = adminTeacher.getAllTeachers();
        for (Map.Entry<String, Teacher> t : teachers.entrySet()){
            System.out.println(t.getValue());
        }
    }

    public void getAllStudents() {
        System.out.println("STUDENTS");
        Map<String, Student> students = adminStudent.getAllStudents();
        for (Map.Entry<String, Student> s : students.entrySet()){
            System.out.println(s.getValue());
        }
    }

    public void deleteCourse() {
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Course currentCourse = adminCourse.getCourse(courseId - 1);
        System.out.println(currentCourse.getCourseName() + " is deleted");
        adminCourse.deleteCourse(currentCourse);
    }

    public void deleteStudent() {
        System.out.println("Enter Student username");
        String username = scanner.next();
        Student currentStudent = adminStudent.getStudent(username);
        System.out.println(currentStudent.getFirstName() + ' ' + currentStudent.getLastName()
                + " was deleted");
        adminStudent.deleteStudent(currentStudent);
    }

    public void deleteTeacher() {
        System.out.println("Enter Teacher username");
        String username = scanner.next();
        Teacher currentTeacher = adminTeacher.getTeacher(username);
        System.out.println(currentTeacher.getFirstName() + ' ' + currentTeacher.getLastName()
                + " was deleted");
        adminTeacher.deleteTeacher(currentTeacher);
        adminPage();
    }

    public void addStudentToCourse() {
        System.out.println("Enter Student username");
        String username = scanner.next();
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Observer observer = adminStudent.getStudent(username);
        Observable course = adminCourse.getCourse(courseId - 1);
        course.addObserver(observer);
        Student currentStudent = adminStudent.getStudent(username);
        Course currentCourse = adminCourse.getCourse(courseId - 1);
        System.out.println(currentStudent.getFirstName() + ' ' + currentStudent.getLastName() +
                ' ' + " was added to the course " + currentCourse.getCourseName());
    }

    public void addTeacherToCourse() {
        System.out.println("Enter Teacher username");
        String username = scanner.next();
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Observer observer = adminTeacher.getTeacher(username);
        Observable course = adminCourse.getCourse(courseId - 1);
        course.addObserver(observer);
        Teacher currentTeacher = adminTeacher.getTeacher(username);
        Course currentCourse = adminCourse.getCourse(courseId - 1);
        System.out.println(currentTeacher.getFirstName() + ' ' + currentTeacher.getLastName() +
                ' ' + " was added to the course " + currentCourse.getCourseName());
    }

    public void removeStudentFromCourse() {
        System.out.println("Enter Student username");
        String username = scanner.next();
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Observer observer = adminStudent.getStudent(username);
        Observable course = adminCourse.getCourse(courseId - 1);
        course.removeObserver(observer);
        Student currentStudent = adminStudent.getStudent(username);
        Course currentCourse = adminCourse.getCourse(courseId - 1);
        System.out.println(currentStudent.getFirstName() + ' ' + currentStudent.getLastName() +
                ' ' + " was removed from the course " + currentCourse.getCourseName());
    }

    public void removeTeacherFromCourse() {
        System.out.println("Enter Teacher username");
        String username = scanner.next();
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Observer observer = adminTeacher.getTeacher(username);
        Observable course = adminCourse.getCourse(courseId - 1);
        course.removeObserver(observer);
        Teacher currentTeacher = adminTeacher.getTeacher(username);
        Course currentCourse = adminCourse.getCourse(courseId - 1);
        System.out.println(currentTeacher.getFirstName() + ' ' + currentTeacher.getLastName() +
                ' ' + " was removed from the course " + currentCourse.getCourseName());
    }

    public void addCourseInfo() {
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Observable course = adminCourse.getCourse(courseId - 1);
        scanner.nextLine();
        System.out.println("Enter information");
        String info = scanner.nextLine();
        course.addSubject(info);
    }

    public void removeCourseInfo() {
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Observable course = adminCourse.getCourse(courseId - 1);
        System.out.println("Enter Information ID");
        int infoId = scanner.nextInt();
        String info = adminCourse.getAllCourses().get(courseId - 1).getSubjects().get(infoId - 1);
        course.removeSubject(info);
    }

    public void notifyAllObservers() {
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        Observable course = adminCourse.getCourse(courseId - 1);
        course.notifyObservers();
    }

    public void getAllInformation() {
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        List<String> courses = adminCourse.getAllCourses().get(courseId - 1).getSubjects();
        System.out.println("INFORMATION");
        for (String c : courses) {
            System.out.println(c);
        }
    }

    public void getAllObservers() {
        System.out.println("Enter Course ID");
        int courseId = scanner.nextInt();
        List<Observer> observers = adminCourse.getAllCourses().get(courseId - 1).getObservers();
        System.out.println("Observers: ");
        for (Observer o : observers) {
            System.out.println(o.toString());
        }
    }
}
