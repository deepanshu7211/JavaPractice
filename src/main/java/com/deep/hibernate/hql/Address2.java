package com.deep.hibernate.hql;

import javax.persistence.*;

/**
 * Created by deepanshu.saxena on 18/02/16.
 */

@Entity
@Table(name = "Address")
public class Address2 {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "city")
    private String city;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address2{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
