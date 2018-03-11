package com.deep.hibernate.one_to_many.one_many_uni_other;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.deep.hibernate.util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 30/07/16.
 */
public class HibernateUniOther {
    public static void main(String[] args) {
        Cart cart1 = new Cart();
        cart1.setName("test");
        cart1.setTotal(2000);


        Item item1 = new Item();
        item1.setItemId("1");
        item1.setItemTotal(100);
        item1.setQuantity(1);
        item1.setCart(cart1);

        Item item2 = new Item();
        item2.setItemId("2");
        item2.setItemTotal(200);
        item2.setQuantity(2);
        item2.setCart(cart1);

        Set<Item> item1Set = new HashSet<>();
        item1Set.add(item1);
        item1Set.add(item2);


        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(item1);
        session.save(item2);
        tx.commit();
        System.out.println("Cart1 ID=" + item1.getId());
//        System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getCart().getId());
//        System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getCart().getId());

        session.close();
        HibernateUtil.buildSessionFactory().close();
    }
}
