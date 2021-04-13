package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EnrolmentHarness {

    public static void main(String[] args) throws IOException {

        //Populating the Student
        Student s1 = new Student("s001", "Chanjeong Park", "20/11/1997");
        Student s2 = new Student("s002", "Jisung Park", "11/11/1999");
        Student s3 = new Student("s003", "Lionel Messi", "07/07/1987");
        Student s4 = new Student("s004", "Michael Jackson", "03/09/1999");
        Student s5 = new Student("s005", "Karim Benzema", "14/07/2000");
        //Populating the Course
        Course c1 = new Course("c001", "Software Engineering", 12);
        Course c2 = new Course("c002", "Web Programming", 12);
        Course c3 = new Course("c003", "Software Architecture", 12);
        Course c4 = new Course("c004", "Programming 1", 12);
        Course c5 = new Course("c005", "Practical Database Concept", 12);

        StudentEnrolment studentEnrolment = new StudentEnrolment(s1, c1, "2021A");
        //Add the student into StudentList
        studentEnrolment.addStudent(s1);
        studentEnrolment.addStudent(s2);
        studentEnrolment.addStudent(s3);
        studentEnrolment.addStudent(s4);
        studentEnrolment.addStudent(s5);
        //Add the Course into CourseList
        studentEnrolment.addCourse(c1);
        studentEnrolment.addCourse(c2);
        studentEnrolment.addCourse(c3);
        studentEnrolment.addCourse(c4);
        studentEnrolment.addCourse(c5);

        //Menu starts with 5 options and it stops when users say "N"
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Add the enrolment" + "\n" +
                    "2.Delete the enrolment" + "\n" +
                    "3.Update the enrolment" + "\n" +
                    "4.Get all enrolment" + "\n" +
                    "5.Get one enrolment");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("1")){
                studentEnrolment.addCourse();
            }
            if(answer.equalsIgnoreCase("2")){
                studentEnrolment.deleteCourse();
            }
            if(answer.equalsIgnoreCase("3")){
                studentEnrolment.updateCourse();
            }
            if(answer.equalsIgnoreCase("4")){
                studentEnrolment.getOne();
            }
            if(answer.equalsIgnoreCase("5")){
                studentEnrolment.getAll();
            }

            System.out.println("Do you want to continue(Y or N)?: ");
            String answer2 = scanner.nextLine();
            if(answer2.equalsIgnoreCase("N")){
                break;
            }
        }

    }
}
