package com.company.strategy;

import com.company.entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherStrategy implements Strategy{
    List<Teacher> list = new ArrayList<>();

    public TeacherStrategy(){
    }

    public void add(Teacher b){
        list.add(b);
    }

    @Override
    public int getIndex(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}