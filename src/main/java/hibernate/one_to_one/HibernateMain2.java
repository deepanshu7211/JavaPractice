package hibernate.one_to_one;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by deepanshu.saxena on 17/02/16.
 */
public class HibernateMain2 {

    public static void main(String[] args) {
        Txn1 txn1 = new Txn1();

        txn1.setTotal(2000);

        Customer1 customer1 = new Customer1();
        customer1.setName("deep");
        customer1.setEmail("deep123");
        customer1.setTxn1(txn1);

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
//        session.save(txn1);
        session.save(customer1);
        tx.commit();
        session.close();
        HibernateUtil.buildSessionFactory().close();
    }
}
