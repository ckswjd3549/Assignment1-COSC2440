package com.company;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager {

    Scanner scanner = new Scanner(System.in);
    private Student student;
    private Course course;
    private String semester;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<StudentEnrolment> studentEnrolmentList = new ArrayList<StudentEnrolment>();

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

    //Add Student into StudentList
    public void addStudent(Student s) {
        studentList.add(s);
    }

    //Add Course into CourseList
    public void addCourse(Course c) {
        courseList.add(c);
    }


    //Ask the users about information of Student and Course.
    //These information is stored as a studentEnrolment in the studentEnrolmentList
    // After that, those information users enter will be stored in the "information.csv" as well
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

    //Bring the addCourse() from the StudentEnrolmentManager interface
    //addCourse function is to check whether student is already populated or not
    //Then, if the student wants to add more courses in the same semester, this system would add more courses for student in same semester
    //After that, these information also stored in "information.csv" file.
    @Override
    public void addCourse() throws IOException {
        StringBuffer information = new StringBuffer();
        System.out.println("Enter the studentName: ");
        String studentName = scanner.nextLine();
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent().getStudentName().equalsIgnoreCase(studentName)) {
                System.out.println("Enter the courseID you want to add: ");
                String courseID = scanner.nextLine();
                System.out.println("Enter the courseName you want to add: ");
                String courseName = scanner.nextLine();
                System.out.println("Enter the numberOfCredit: ");
                int numberOfCredit = scanner.nextInt();
                Course course = new Course(courseID, courseName, numberOfCredit);
                for (StudentEnrolment se1 : studentEnrolmentList) {
                    if (!se.getCourse().getCourseName().equalsIgnoreCase(courseName)) {
                        StudentEnrolment studentEnrolment = new StudentEnrolment(se.student, course, se.semester);
                        studentEnrolmentList.add(studentEnrolment);
                        information.append(se.student.getStudentID() + " " + se.student.getStudentName() + " " + se.student.getBirthdate()
                                + " " + course.getCourseID() + " " + course.getCourseName() + " " + course.getNumberOfCredits() + "  "
                                + semester + "\n");
                        System.out.println("Course is added successfully");
                    }
                }
            }
        }
        PrintWriter printWriter = new PrintWriter(new FileWriter("information.csv", true));
        printWriter.print(information.toString());
        printWriter.close();
    }

    //Method asks the user to put the information about the studentID.
    //After that if it's corresponding with list in studentEnrolment,
    //they will require courseID and semester more, then if it's all correct, it will be deleted
    @Override
    public void deleteCourse() {
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
                        for (StudentEnrolment se : studentEnrolmentList) {
                            if (se.equals(new StudentEnrolment(s, c, semester))) {
                                studentEnrolmentList.remove(se);
                                System.out.println("Course is deleted successfully!");
                            }
                        }
                    }
                }
            }
        }
    }

    //Method asks users studendID, then if it matches with the existed information,
    //they ask again about the information of course and check if the course which is typed is existed or not
    //After that, the new information of Course will be updated
    @Override
    public void updateCourse() throws IOException {
        StringBuffer information = new StringBuffer();
        System.out.println("Enter the studentID: ");
        String studentID = scanner.nextLine();
        for (Student s : studentList) {
            if (s.getStudentID().equalsIgnoreCase(studentID)) {
                System.out.println("What course do you want to update?: ");
                String courseID = scanner.nextLine();
                for (Course c : courseList) {
                    if (c.getCourseID().equalsIgnoreCase(courseID)) {
                        System.out.println("Enter the new courseID: ");
                        String newCourseID = scanner.nextLine();
                        System.out.println("Enter the new courseName ");
                        String newCourseName = scanner.nextLine();
                        System.out.println("Enter the numberOfCredit: ");
                        int newNumberOfCredit = scanner.nextInt();
                        Course course = new Course(newCourseID, newCourseName, newNumberOfCredit);
                        if(courseList.contains(course)) {
                            c.setCourseID(newCourseID);
                            c.setCourseName(newCourseName);
                            c.setNumberOfCredits(newNumberOfCredit);
                            System.out.println("course is updated!");
                            information.append(s.getStudentID() + " " + s.getStudentName() + " " + s.getBirthdate()
                                    + " " + newCourseID + " " + c.getCourseName() + " " + c.getNumberOfCredits() + "  "
                                    + semester + "\n");
                        }
                    }
                }
            }
        }
        PrintWriter printWriter = new PrintWriter(new FileWriter("information.csv", true));
        printWriter.print(information.toString());
        printWriter.close();
    }

    //Scan the studentID first, and then if the courseID and semester are also matched.
    //then the information which users want to search will be printed.
    @Override
    public void getOne() {
        System.out.println("Enter the studentID: ");
        String studentID = scanner.nextLine();
        for(Student s: studentList) {
            if(s.getStudentID().equalsIgnoreCase(studentID)){
                System.out.println("Enter the courseID: ");
                String courseID = scanner.nextLine();
                for(Course c: courseList){
                    if(c.getCourseID().equalsIgnoreCase(courseID)){
                        System.out.println("Enter the semester: ");
                        String semester = scanner.nextLine();
                        StudentEnrolment se = new StudentEnrolment(s, c, semester);
                        if(studentEnrolmentList.contains(se)){
                            System.out.println(se);
                        }
                    }
                }
            }
        }
    }

    //There are three options given for users.
    //Therefore, users can choose
    //After that, if the information which users typed is matched with the information in the list,
    //this method will show the all results regarding the function
    @Override
    public void getAll() {
        System.out.println("1.All courses for one student in 1 semester\n" +
                            "2. All students of one course in 1 semester\n" +
                            "3.All courses offered in 1 semester");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("1")) {
            System.out.println("Enter the studentID: ");
            String studentID = scanner.nextLine();
            for (Student s : studentList) {
                if (s.getStudentID().equalsIgnoreCase(studentID)) {
                    System.out.println("Enter the semester: ");
                    String semester = scanner.nextLine();
                    for(StudentEnrolment se: studentEnrolmentList){
                        if(se.getSemester().equalsIgnoreCase(semester)){
                            System.out.println(se.getCourse() + "\n");
                        }
                    }
                }
            }
        }
        if(answer.equalsIgnoreCase("2")){
            System.out.println("Enter the courseID: ");
            String courseID = scanner.nextLine();
            for(Course c: courseList){
                if(c.getCourseID().equalsIgnoreCase(courseID)){
                    System.out.println("Enter the semester: ");
                    String semester = scanner.nextLine();
                    for(StudentEnrolment se: studentEnrolmentList){
                        if(se.getSemester().equalsIgnoreCase(semester)){
                            System.out.println(se.getStudent() + "\n");
                        }
                    }
                }
            }
        }
        if(answer.equalsIgnoreCase("3")){
            System.out.println("Enter the semester: ");
            String semester = scanner.nextLine();
            for(StudentEnrolment se: studentEnrolmentList){
                if(se.getSemester().equalsIgnoreCase(semester)){
                    System.out.println(se.getCourse() + "\n");
                }
            }
        }
    }
}

