package com.deep.spring.depen_by_const;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Employee {
    private int id;
    private String name;

    public Employee() {
        System.out.println("default constructor");
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void show() {
        System.out.println(id + " " + name);
    }
}
