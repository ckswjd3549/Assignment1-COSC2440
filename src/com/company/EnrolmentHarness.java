package com.company;

import java.io.IOException;

public class EnrolmentHarness {

    public static void main(String[] args) {

        Course c1 = new Course("c001", "Software Engineering", 12);
        Student s1 = new Student("s3712688", "Chanjeong Park", "20/11/1997");
        Student s2 = new Student("s1234566", "Jisung Park", "11/11/1999");


        StudentEnrolment studentEnrolment = new StudentEnrolment(s1, c1, "2021A");
        studentEnrolment.addStudent(s1);
        studentEnrolment.addStudent(s2);
        studentEnrolment.addCourse(c1);

        try {
            studentEnrolment.enrollStudent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
