package com.deep.hibernate.one_to_one.using_mapped_by;

import javax.persistence.*;

/**
 * Created by deepanshu.saxena on 26/05/16.
 */

@Entity
@Table(name = "txnm")
public class TxnM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_id")
    private long id;


    @Column(name = "txn_total")
    private double total;


    @OneToOne(mappedBy = "txn")
    private CustomerM customerM;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public CustomerM getCustomerM() {
        return customerM;
    }

    public void setCustomerM(CustomerM customerM) {
        this.customerM = customerM;
    }
}
