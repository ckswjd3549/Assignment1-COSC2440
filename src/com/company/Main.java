package com.company;

public class Main {

    public static void main(String[] args) {
        StudentEnrolment studentEnrolment = new StudentEnrolment("2021A");
        Course c1 = new Course("c001", "Software Engineering");
        Student s1 = new Student("s3712688", "Chanjeong Park", "971120");
        Student s2 = new Student("s1234566", "ABASDFWER", "991234");
        System.out.println(studentEnrolment.getCourseList());
    }
}
