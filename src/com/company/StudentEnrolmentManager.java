package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public interface StudentEnrolmentManager{

    public void enrollStudent() throws IOException;
    public void addCourse();
    public void deleteCourse();
    public void updateCourse();
    public void getOne();
    public void getAll();

}
