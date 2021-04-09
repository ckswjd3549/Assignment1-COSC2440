package com.company;

import java.io.IOException;

public class EnrolmentHarness {

    public static void main(String[] args) throws IOException {

        Student s1 = new Student("s001", "Chanjeong Park", "20/11/1997");
        Student s2 = new Student("s002", "Jisung Park", "11/11/1999");
        Student s3 = new Student("s003", "Lionel Messi", "07/07/1987");
        Student s4 = new Student("s004", "Michael Jackson", "03/09/1999");
        Student s5 = new Student("s005", "Karim Benzema", "14/07/2000");

        Course c1 = new Course("c001", "Software Engineering", 12);
        Course c2 = new Course("c002", "Web Programming", 12);
        Course c3 = new Course("c003", "Software Architecture", 12);
        Course c4 = new Course("c004", "Programming 1", 12);
        Course c5 = new Course("c005", "Practical Database Concept", 12);

        StudentEnrolment studentEnrolment = new StudentEnrolment(s1, c1, "2021A");

        studentEnrolment.addStudent(s1);
        studentEnrolment.addStudent(s2);
        studentEnrolment.addStudent(s3);
        studentEnrolment.addStudent(s4);
        studentEnrolment.addStudent(s5);
        studentEnrolment.addCourse(c1);
        studentEnrolment.addCourse(c2);
        studentEnrolment.addCourse(c3);
        studentEnrolment.addCourse(c4);
        studentEnrolment.addCourse(c5);

        studentEnrolment.enrollStudent();
        studentEnrolment.getAll();


    }
}
