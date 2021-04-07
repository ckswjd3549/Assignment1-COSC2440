package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager{

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> studentList;
    private ArrayList<Course> courseList;
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

    public void containStudent(Student s){
        studentList.add(s);
    }

    public void containCourse(Course c){
        courseList.add(c);
    }


    @Override
    public void enrollStudent() {
        System.out.println("Enter the studentID: ");
        String studentID = scanner.nextLine();
        for(Student s: studentList){
            if(s.getStudentID().equalsIgnoreCase(studentID)){
                ArrayList<Student> newStudentList = new ArrayList<Student>();
                newStudentList.add(s);
                System.out.println("Enter the courseName: ");
                String courseName = scanner.nextLine();
                for(Course c: courseList){
                    if(c.getCourseID().equalsIgnoreCase(courseName)){
                        ArrayList<Course> newCourseList = new ArrayList<Course>();
                        newCourseList.add(c);
                        System.out.println("Enter the semester: ");
                        String semester = scanner.nextLine();
                        StudentEnrolment studentEnrolment = new StudentEnrolment(newStudentList, newCourseList, semester);
                    }
                }
            }
        }
    }

    @Override
    public void addCourse() {

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


}





//        System.out.println("*** Enter the Course\n >>>");
//        String courseName = scanner.nextLine();
//        System.out.println("*** Enter the Semester\n >>>");
//        String semester = scanner.nextLine();
//        System.out.println("\"*** Enter the studentID\\n >>>\"");
//        String studentID = scanner.nextLine();
//        for(int i = 0; i < courseList.size(); i++){
//            if(courseList.get(i).getcourseName().equalsIgnoreCase(courseName)
//                    && this.semester.equalsIgnoreCase(semester)
//                    && studentList.get(i).getStudentID().equalsIgnoreCase(studentID)){
//            }
//        }
//        return false;