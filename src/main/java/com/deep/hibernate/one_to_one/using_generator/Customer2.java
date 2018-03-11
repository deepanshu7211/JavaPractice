package com.deep.hibernate.one_to_one.using_generator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by deepanshu.saxena on 26/04/16.
 */
public class Customer2 {

    @Id
    @Column(name = "txn_id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = {@Parameter(name = "property", value = "txn")})
    private long id;

    @Column(name = "cust_name")
    private String name;

    @Column(name = "cust_email")
    private String email;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Txn2 txn;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Txn2 getTxn() {
        return txn;
    }

    public void setTxn(Txn2 txn) {
        this.txn = txn;
    }
}
