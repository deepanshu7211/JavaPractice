package hibernate.hibernate_save_update;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by deepanshu.saxena on 30/05/16.
 */
public class HibernateSaveMerge {
    public static void main(String[] args) {


        // For Save
//        Session session= HibernateUtil.getSessionFactory().openSession();
//        Transaction tx=session.beginTransaction();
//        EmployeEntity employee2=getTestEmployee();
//        long id= (Long) session.save(employee2);
//        System.out.println("id :: " + id);
//        tx.commit();
//        session.close();
//        HibernateUtil.shutdown();

        // For Update
//        Session session= HibernateUtil.getSessionFactory().openSession();
//        Transaction tx=session.beginTransaction();
//        EmployeEntity employee2= getTestEmployee();  //For Update
//        employee2.setName("tmp");
////        session.save(employee2); // Save will throw error Duplicate entry '1' for key 'PRIMARY'
//        session.update(employee2);
//        tx.commit();
//        session.close();
//        HibernateUtil.shutdown();

        // SaveOrUpdate case

//        Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
//        sessionTwo.beginTransaction();

//        employee2.setName("temp");
        //Save employee again second time
//        sessionTwo.save(employee2);  // if save()  it will throw Duplicate entry '1' for key 'PRIMARY' .
//        sessionTwo.update(employee2); // By commenting session.save() first method it will throw error  Batch update returned unexpected row count from update
//        sessionTwo.saveOrUpdate(employee2);  // It will save or update
//        sessionTwo.getTransaction().commit();
//        HibernateUtil.shutdown();


        // Merge

        Session session3 = HibernateUtil.getSessionFactory().openSession();
        EmployeEntity employeEntity = (EmployeEntity) session3.get(EmployeEntity.class, new Long(1));
        Transaction tx1 = session3.beginTransaction();

        tx1.commit();

        session3.close();
        employeEntity.setName("deep update");


        Session session4 = HibernateUtil.getSessionFactory().openSession();
        EmployeEntity employeEntity2 = (EmployeEntity) session4.get(EmployeEntity.class, new Long(1));  //Same Object is loaded from the database

        Transaction tx = session4.beginTransaction();
        System.out.println("name :: " + employeEntity2.getName() + " id :: " + employeEntity2.getId());

        // In case of same session
//        EmployeEntity employeEntity3=new EmployeEntity();
//        employeEntity3.setId(1);
//        employeEntity3.setName("deep");
//
//        session4.merge(employeEntity3);  // Only merge will work all other will throw error NonUniqueObjectException


//        session4.update(employeEntity);  // NonUniqueObjectException: A different object with the same identifier value was already associated with the session
//        session4.saveOrUpdate(employeEntity);  // Same Error
//        session4.merge(employeEntity);
//        session4.merge(emp2);
        tx.commit();
        session4.close();
        HibernateUtil.shutdown();


    }

    public static EmployeEntity getTestEmployee() {
        EmployeEntity emp = new EmployeEntity();
        emp.setId(1);
        emp.setName("Test Emp");
        return emp;
    }

}
