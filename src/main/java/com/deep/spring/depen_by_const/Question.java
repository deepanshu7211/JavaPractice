package com.deep.spring.depen_by_const;

import java.util.List;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Question {

    private int id;
    private String name;
    private List<String> answers;

    public Question() {
    }

    public Question(int id, String name, List<String> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public void displayInfo() {
        System.out.println(id + " " + name);
        System.out.println("answers are:");
        for (String str : answers) {
            System.out.println(str);
        }
    }
}
