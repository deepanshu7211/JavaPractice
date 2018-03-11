package com.deep.hibernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.deep.hibernate.util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by deepanshu.saxena on 18/02/16.
 */
public class Hibernate3 {
    public static void main(String[] args) {

        Item2 item1 = new Item2();
        item1.setItemId("1");
        item1.setItemTotal(100);
        item1.setQuantity(1);

        Item2 item2 = new Item2();
        item2.setItemId("2");
        item2.setItemTotal(200);
        item2.setQuantity(2);

        Set<Item2> item2s = new HashSet<>();
        item2s.add(item1);
        item2s.add(item2);


        Cart2 cart1 = new Cart2();
        cart1.setName("test");
        cart1.setTotal(2000);
        cart1.setItem2s(item2s);

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();


        session.save(cart1);
        tx.commit();

        System.out.println("Cart1 ID=" + cart1.getId());
        System.out.println("item1 ID=" + item1.getId());
        System.out.println("item2 ID=" + item2.getId());

        session.close();
        HibernateUtil.buildSessionFactory().close();

    }
}
