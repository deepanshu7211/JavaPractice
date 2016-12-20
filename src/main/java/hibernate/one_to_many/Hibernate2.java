package hibernate.one_to_many;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 17/02/16.
 */
public class Hibernate2 {
    public static void main(String[] args) {
        Cart1 cart1 = new Cart1();
        cart1.setName("test");
        cart1.setTotal(2000);

        Cart1 cart2;

        Item1 item1 = new Item1();
        item1.setItemId("1");
        item1.setItemTotal(100);
        item1.setQuantity(1);
        item1.setCart1(cart1);

        Item1 item2 = new Item1();
        item2.setItemId("2");
        item2.setItemTotal(200);
        item2.setQuantity(2);
        item2.setCart1(cart1);

        Set<Item1> item1Set = new HashSet<>();
        item1Set.add(item1);
        item1Set.add(item2);


        cart1.setItem1(item1Set);

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        // Delete Example
//        cart2= (Cart1) session.load(Cart1.class,new Long(2));
//        session.delete(cart2);


        session.save(item1);
//          session.save(cart1);
//          session.save(item2);

        tx.commit();
        System.out.println("Cart1 ID=" + cart1.getId());
        System.out.println("item1 ID=" + item1.getId() + ", Foreign Key Cart ID=" + item1.getCart1().getId());
        System.out.println("item2 ID=" + item2.getId() + ", Foreign Key Cart ID=" + item1.getCart1().getId());

        session.close();
        HibernateUtil.buildSessionFactory().close();
    }
}
