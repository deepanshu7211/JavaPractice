package com.deep.spring.depen_by_const;

import java.util.List;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Ques {
    private int id;
    private String name;
    private List<Answers> answers;

    public Ques(int id, String name, List<Answers> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public void displayInfo() {
        System.out.println(id + " " + name);
        System.out.println("answers are:");
        for (Answers answer : answers)
            System.out.println(answer.toString());
    }
}
