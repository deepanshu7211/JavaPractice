package hibernate.basic;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by deepanshu.saxena on 17/02/16.
 */
public class HibernateMain1 {

    public static void main(String[] args) {
        Employee1 employee1 = new Employee1();
        employee1.setName("deep");
        employee1.setRole("test");

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee1);
        tx.commit();
        System.out.println("id :: " + employee1.getId());
        session.close();
        HibernateUtil.buildSessionFactory().close();
    }
}
