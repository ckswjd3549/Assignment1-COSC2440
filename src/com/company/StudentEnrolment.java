package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolment extends Course implements StudentEnrolmentManager{

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private String semester;

    public StudentEnrolment(String semester) {
        super();
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
    public boolean enrollStudent() {
        System.out.println("*** Enter the Course\n >>>");
        String courseName = scanner.nextLine();
        System.out.println("*** Enter the Semester\n >>>");
        String semester = scanner.nextLine();
        System.out.println("\"*** Enter the studentID\\n >>>\"");
        String studentID = scanner.nextLine();
        for(int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).getcourseName() == courseName
                    && this.semester == semester
                    && studentList.get(i).getStudentID() == studentID){
                System.out.println(courseList.get(i));
            }
        }
        return false;
    }

    @Override
    public boolean addCourse() {
        return false;
    }

    @Override
    public void deleteCourse() {

    }

    @Override
    public void updateCourse() {

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
