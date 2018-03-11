package com.deep.spring.depen_by_setter;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Add {
    private String city;
    private String state;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Add{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
