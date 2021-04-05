package com.company;



public class Course {

    private String courseID;
    public static String courseName;
    private int numberOfCredits;


    public Course() {

    }
    public Course(String courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
    }


    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                '}';
    }
}
