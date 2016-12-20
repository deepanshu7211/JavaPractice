package hibernate.hql;

import hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by deepanshu.saxena on 18/02/16.
 */
public class HibernateCriteria {
    public static void main(String[] args) {
        // Prep work

        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        //Get All Employees
        Criteria criteria = session.createCriteria(Employee2.class);
        List<Employee2> empList = criteria.list();
        for (Employee2 emp : empList) {
            System.out.println("ID=" + emp.getId() + ", Zipcode=" + emp.getAddress2().getCity());
        }

        // Get with ID, creating new Criteria to remove all the settings
        criteria = session.createCriteria(Employee2.class)
                .add(Restrictions.eq("id", new Long(1)));
        Employee2 emp = (Employee2) criteria.uniqueResult();
        System.out.println("Name=" + emp.getName() + ", City="
                + emp.getAddress2().getCity());

        //Pagination Example
        empList = session.createCriteria(Employee2.class)
                .addOrder(Order.desc("id"))
                .setFirstResult(0)
                .setMaxResults(2)
                .list();
        for (Employee2 emp4 : empList) {
            System.out.println("Paginated Employees::" + emp4.getId() + "," + emp4.getAddress2().getCity());
        }

        //Like example
        empList = session.createCriteria(Employee2.class)
                .add(Restrictions.like("name", "%i%"))
                .list();
        for (Employee2 emp4 : empList) {
            System.out.println("Employees having 'i' in name::" + emp4.getName() + "," + emp4.getAddress2().getCity());
        }

        //Projections example
        long count = (Long) session.createCriteria(Employee2.class)
                .setProjection(Projections.rowCount())
                .add(Restrictions.like("name", "%i%"))
                .uniqueResult();
        System.out.println("Number of employees with 'i' in name=" + count);

        //using Projections for sum, min, max aggregation functions
        double sumSalary = (Double) session.createCriteria(Employee2.class)
                .setProjection(Projections.sum("salary"))
                .uniqueResult();
        System.out.println("Sum of Salaries=" + sumSalary);

        //Join example for selecting few columns
//        criteria = session.createCriteria(Employee2.class, "employee");
//        criteria.setFetchMode("employee.address2", FetchMode.JOIN);
//        criteria.createAlias("employee.address", "address"); // inner join by default
//
//        ProjectionList columns = Projections.projectionList()
//                .add(Projections.property("name"))
//                .add(Projections.property("address.city"));
//        criteria.setProjection(columns);
//
//        List<Object[]> list = criteria.list();
//        for(Object[] arr : list){
//            System.out.println(Arrays.toString(arr));
//        }


        tx.commit();
        session.close();
        HibernateUtil.buildSessionFactory().close();

    }

}

