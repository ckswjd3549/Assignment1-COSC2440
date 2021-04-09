package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public interface StudentEnrolmentManager{

    public void enrollStudent() throws IOException;
    public void addCourse() throws IOException;
    public void deleteCourse();
    public void updateCourse() throws IOException;
    public void getOne();
    public void getAll();

}
