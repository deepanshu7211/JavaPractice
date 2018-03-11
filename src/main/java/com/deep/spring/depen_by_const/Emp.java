package com.deep.spring.depen_by_const;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Emp {
    private int id;
    private String name;
    private Address address;


    public Emp() {
    }

    public Emp(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void show() {
        System.out.println(id + " " + name);
        System.out.println(address.toString());
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address.toString() +
                '}';
    }
}
