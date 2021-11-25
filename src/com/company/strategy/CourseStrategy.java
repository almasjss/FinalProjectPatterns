package com.company.strategy;

import com.company.entities.Course;

import java.util.ArrayList;

public class CourseStrategy implements Strategy {
    ArrayList<Course> list;

    public CourseStrategy(){
        list = new ArrayList<>();
    }

    public void add(Course c){
        list.add(c);
    }

    @Override
    public int getIndex(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCourseId() == id){
                return i;
            }
        }
        return -1;
    }
}