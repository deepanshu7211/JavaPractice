package hibernate.one_to_one.using_mapped_by;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by deepanshu.saxena on 26/05/16.
 */
public class HibernateMappedByMain {

    public static void main(String[] args) {
        TxnM txn1 = new TxnM();

        txn1.setTotal(2000);

        CustomerM customer1 = new CustomerM();
        customer1.setName("deep");
        customer1.setEmail("deep123");
        customer1.setTxn(txn1);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
//        session.save(txn1);
        session.save(customer1);
        tx.commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
