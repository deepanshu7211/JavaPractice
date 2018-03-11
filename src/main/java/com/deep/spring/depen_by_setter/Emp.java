package com.deep.spring.depen_by_setter;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Emp {
    private int id;
    private String name;
    private String city;
    private Add add;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Add getAdd() {
        return add;
    }

    public void setAdd(Add add) {
        this.add = add;
    }

    public void show() {
        System.out.println("id " + getId() + " name " + getName() + " city " + getCity());
        System.out.println("address :: " + add.toString());
    }
}
