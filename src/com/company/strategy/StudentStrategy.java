package com.company.strategy;

import com.company.entities.Student;

import java.util.ArrayList;

public class StudentStrategy implements Strategy {
    ArrayList<Student> list;

    public StudentStrategy() {
        list = new ArrayList<>();
    }

    public void add(Student a){
        list.add(a);
    }

    @Override
    public int getIndex(int id) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
