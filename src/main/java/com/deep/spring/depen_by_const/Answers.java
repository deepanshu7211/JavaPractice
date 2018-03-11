package com.deep.spring.depen_by_const;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Answers {
    private int id;
    private String name;


    public Answers(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
