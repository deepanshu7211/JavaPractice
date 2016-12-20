package hibernate.hibernate_save_update;

import hibernate.hql.Address2;
import hibernate.hql.Employee2;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by deepanshu.saxena on 18/02/16.
 */
public class HibernateSavePersist {
    public static void main(String[] args) {
        // Prep Work
        Session session = HibernateUtil.buildSessionFactory().openSession();

        //save example - without transaction

//        Employee2 emp = getTestEmployee();
//        long id = (Long) session.save(emp);
//        System.out.println("1. Employee save called without transaction, id="+id);
//        session.flush(); //address will not get saved without this
//        System.out.println("*****");

        //save example - with transaction

//        Session session1 = HibernateUtil.buildSessionFactory().openSession();
//        Transaction tx1 = session1.beginTransaction();
//        Employee2 emp1 = getTestEmployee();
//        long id1 = (Long) session1.save(emp1);
//        System.out.println("2. Employee save called with transaction, id="+id1);
//        System.out.println("3. Before committing save transaction");
//        tx1.commit();
//        System.out.println("4. After committing save transaction");
//        System.out.println("*****");
//
//
//
//      save example - existing row in table
        Session session6 = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx6 = session6.beginTransaction();
        Employee2 emp6 = (Employee2) session6.load(Employee2.class, new Long(1));

        //update some data
        System.out.println("Employee Details=" + emp6);
        emp6.setName("New Name");
        emp6.getAddress2().setCity("New City");

        long id6 = (Long) session6.save(emp6);
        emp6.setName("New Name1"); // will get updated in database
        System.out.println("5. Employee save called with transaction, id=" + id6);
        System.out.println("6. Before committing save transaction");
        tx6.commit();
        System.out.println("7. After committing save transaction");
        System.out.println("*****");

        // Close resources
        HibernateUtil.buildSessionFactory().close();
    }

    public static Employee2 getTestEmployee() {
        Employee2 emp = new Employee2();
        Address2 add = new Address2();
        emp.setName("Test Emp");
        emp.setSalary(1000);
        add.setCity("Test City");
        emp.setAddress2(add);
        return emp;
    }
}
