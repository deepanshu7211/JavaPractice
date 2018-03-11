package com.deep.hibernate.one_to_one.using_generator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created by deepanshu.saxena on 26/04/16.
 */

@Entity
@Table(name = "Txn2")
public class Txn2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_id")
    private int id;

    @Column(name = "amount")
    private double amount;

    @OneToOne(mappedBy = "txn")
    @Cascade(value = CascadeType.SAVE_UPDATE)
    private Customer2 customer2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer2 getCustomer2() {
        return customer2;
    }

    public void setCustomer2(Customer2 customer2) {
        this.customer2 = customer2;
    }
}
