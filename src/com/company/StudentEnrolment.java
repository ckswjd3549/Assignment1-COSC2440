package com.company;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager{

    Scanner scanner = new Scanner(System.in);
    private Student student;
    private Course course;
    private String semester;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<StudentEnrolment> studentEnrolmentList= new ArrayList<StudentEnrolment>();

    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
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

    public void addStudent(Student s){
            studentList.add(s);
    }

    public void addCourse(Course c){
        courseList.add(c);
    }


    @Override
    public void enrollStudent() throws IOException {
        StringBuffer information = new StringBuffer();
            System.out.println("Enter the studentID: ");
            String studentID = scanner.nextLine();
            for (Student s : studentList) {
                if (s.getStudentID().equalsIgnoreCase(studentID)) {
                    System.out.println("Enter the courseID: ");
                    String courseID = scanner.nextLine();
                    for (Course c : courseList) {
                        if (c.getCourseID().equalsIgnoreCase(courseID)) {
                            System.out.println("Enter the semester: ");
                            String semester = scanner.nextLine();
                            StudentEnrolment studentEnrolment = new StudentEnrolment(s, c, semester);
                            studentEnrolmentList.add(studentEnrolment);
                            System.out.println("Student is enrolled successfully");
                            information.append(s.getStudentID() + " " + s.getStudentName() + " " + s.getBirthdate()
                            + " " + c.getCourseID() + " " + c.getCourseName() + " " + c.getNumberOfCredits() + "  "
                            + semester + "\n");
                        }
                    }
                }
            }

        PrintWriter printWriter = new PrintWriter(new FileWriter("information.csv", true));
        printWriter.print(information.toString());
        printWriter.close();
    }

    @Override
    public void addCourse() {
        System.out.println("Enter the studentName: ");
        String studentName = scanner.nextLine();
        for(StudentEnrolment se: studentEnrolmentList){
            if(se.getStudent().getStudentName().equalsIgnoreCase(studentName)){
                System.out.println("Enter the courseID you want to add: ");
                String courseID = scanner.nextLine();
                System.out.println("Enter the courseName you want to add: ");
                String courseName = scanner.nextLine();
                System.out.println("Enter the numberOfCredit: ");
                int numberOfCredit = scanner.nextInt();
                Course course = new Course(courseID, courseName, numberOfCredit);
                for(StudentEnrolment se1: studentEnrolmentList){
                    if(!se.getCourse().getCourseName().equalsIgnoreCase(courseName)){
                        StudentEnrolment studentEnrolment = new StudentEnrolment(se.student, course, se.semester);
                        studentEnrolmentList.add(studentEnrolment);
                        System.out.println("Course is added successfully");
                    }
                }
            }
        }
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


