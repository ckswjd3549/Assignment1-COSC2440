package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager{

    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private String semester;

    public StudentEnrolment() {
        this.studentList = studentList;
        this.courseList = courseList;
        this.semester = semester;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public boolean addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student you want to add: ");
        String student = scanner.nextLine();
        if(!studentList.contains(student)){
            System.out.println("The student doesn't exist");
            return false;
        }
        else{
            System.out.println("Enter the course you want to add: ");
            String
        }
    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void getOne() {

    }

    @Override
    public void getAll() {

    }

    @Override
    public String toString() {
        return "StudentEnrolment{" +
                "studentList=" + studentList +
                ", courseList=" + courseList +
                ", semester='" + semester + '\'' +
                '}';
    }

}
