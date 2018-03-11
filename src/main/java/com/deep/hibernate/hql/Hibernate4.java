package com.deep.hibernate.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.deep.hibernate.util.HibernateUtil;

import java.util.List;


/**
 * Created by deepanshu.saxena on 18/02/16.
 */
public class Hibernate4 {
    public static void main(String[] args) {
        Address2 address2 = new Address2();
        address2.setCity("delhi");

        Employee2 employee2 = new Employee2();
        employee2.setName("deep");
        employee2.setSalary(100);
        employee2.setAddress2(address2);

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();


        session.save(employee2);


        Query query = session.createQuery("from Employee2");
        List<Employee2> employee2List = query.list();

        for (Employee2 employee21 : employee2List) {
            System.out.println(" name :: " + employee21.getName() + "  city name :: " + employee21.getAddress2().getCity());
        }
//
//        //update query
//
//        query = session.createQuery("update Employee2 set name= :name where id= :id");
//        query.setParameter("name", "deepanshu");
//        query.setLong("id", 2);
//        int result = query.executeUpdate();
//        System.out.println("Employee2 Update Status="+result);
//
//        //delete query
//
//        query = session.createQuery("delete from Employee2 where id= :id");
//        query.setLong("id", 1);
//        result = query.executeUpdate();
//        System.out.println("Employee2 Delete Status="+result);
//
//        // Join
//
//        query = session.createQuery("select e.name, a.city from Employee2 e "
//                + "INNER JOIN e.address2 a");
//        List<Object[]> list = query.list();
//        for(Object[] arr : list){
//            System.out.println(Arrays.toString(arr));
//        }

        tx.commit();
        session.close();
        HibernateUtil.buildSessionFactory().close();

    }
}
