package com.deep.guice;

/**
 * Created by deepanshu.saxena on 17/05/16.
 */
public class Contact {
    private String phone;

    public Contact() {
        this.phone = "12345";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
