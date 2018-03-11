package com.deep.hibernate.one_to_many.one_to_many_bi_other;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.deep.hibernate.util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 26/05/16.
 */
public class BiMain {
    public static void main(String[] args) {
        CartBi cart1 = new CartBi();
        cart1.setName("test");
        cart1.setTotal(2000);


        ItemBi item1 = new ItemBi();
        item1.setItemId("1");
        item1.setItemTotal(100);
        item1.setQuantity(1);
//        item1.setCartBi(cart1);

        ItemBi item2 = new ItemBi();
        item2.setItemId("2");
        item2.setItemTotal(200);
        item2.setQuantity(2);
//        item2.setCartBi(cart1);

        Set<ItemBi> item1Set = new HashSet<>();
        item1Set.add(item1);
        item1Set.add(item2);


        cart1.setItem1(item1Set);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        // Delete Example
//        cart2= (Cart1) session.load(Cart1.class,new Long(2));
//        session.delete(cart2);


        session.save(cart1);

//          session.save(item1);
//          session.save(item2);

//          session.save(cart1);
//          session.save(item2);

        tx.commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
