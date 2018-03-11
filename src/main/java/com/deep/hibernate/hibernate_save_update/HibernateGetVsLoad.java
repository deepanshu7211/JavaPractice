package com.deep.hibernate.hibernate_save_update;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.deep.hibernate.hql.Employee2;
import com.deep.hibernate.util.HibernateUtil;

/**
 * Created by deepanshu.saxena on 18/02/16.
 */
public class HibernateGetVsLoad {

    public static void main(String[] args) {
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        //Get Example
        Employee2 emp = (Employee2) session.get(Employee2.class, new Long(1));
        System.out.println("Employee get called");
        System.out.println("Employee ID= " + emp.getId());
        System.out.println("Employee Get Details:: " + emp + "\n");

        //load Example
        Employee2 emp1 = (Employee2) session.load(Employee2.class, new Long(1));
        System.out.println("Employee load called");
        System.out.println("Employee ID= " + emp1.getId());
        System.out.println("Employee load Details:: " + emp1 + "\n");

        //Get Example
        try {
            Employee2 emp2 = (Employee2) session.get(Employee2.class, new Long(200));
            System.out.println("Employee get called");
            if (emp2 != null) {
                System.out.println("Employee GET ID= " + emp2.getId());
                System.out.println("Employee Get Details:: " + emp2 + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//load Example
        try {
            Employee2 emp3 = (Employee2) session.load(Employee2.class, new Long(100));
            System.out.println("Employee load called");
            System.out.println("Employee LOAD ID= " + emp3.getId());
            System.out.println("Employee load Details:: " + emp3 + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Close resources
        tx.commit();
        session.close();
        HibernateUtil.buildSessionFactory().close();
    }
}
