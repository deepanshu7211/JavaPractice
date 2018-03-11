package com.deep.guice;

import com.google.inject.Inject;

/**
 * Created by deepanshu.saxena on 17/05/16.
 */

//@Singleton
public class Person implements PersonInter {


    private String name;

    //    @Inject
    private Address address;

    //    @Inject  //varible Injector
    private Contact contact;


    public Person() {
        System.out.println(" inside person default constructor ");
        this.name = "deep";

    }


    @Inject //Constructor Injector
    public Person(Address address, Contact contact) {
        System.out.println(" person  constructor called ");
        this.name = "deep";
        this.address = address;
        this.contact = contact;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                '}';
    }


    @Override
    public Person getPerson() {
        return new Person();
    }
}
