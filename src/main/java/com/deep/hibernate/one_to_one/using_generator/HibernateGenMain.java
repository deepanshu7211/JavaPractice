package com.deep.hibernate.one_to_one.using_generator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.deep.hibernate.util.HibernateUtil;

/**
 * Created by deepanshu.saxena on 26/04/16.
 */
public class HibernateGenMain {
    public static void main(String[] args) {
        Txn2 txn1 = new Txn2();

        txn1.setAmount(2000);

        Customer2 customer1 = new Customer2();
        customer1.setName("deep");
        customer1.setEmail("deep123");

        txn1.setCustomer2(customer1);

        customer1.setTxn(txn1);

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(txn1);
        tx.commit();
        session.close();
        HibernateUtil.buildSessionFactory().close();
    }
}
