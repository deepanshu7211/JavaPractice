package spr.hib;

import org.hibernate.FlushMode;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu.saxena on 02/03/16.
 */
public class EmployeeDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public void saveEmployee(Employee e) {
        hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
        hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);

        hibernateTemplate.save(e);
        hibernateTemplate.getSessionFactory().getCurrentSession().getTransaction().commit();

//        hibernateTemplate.getSessionFactory().getCurrentSession().getTransaction().commit();

    }

    //method to update employee
    public void updateEmployee(Employee e) {
        hibernateTemplate.update(e);
    }

    //method to delete employee
    public void deleteEmployee(Employee e) {
        hibernateTemplate.delete(e);
    }

    //method to return one employee of given id
    public Employee getById(int id) {
        Employee e = (Employee) hibernateTemplate.get(Employee.class, id);
        return e;
    }

    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = hibernateTemplate.loadAll(Employee.class);
        return employeeList;
    }
}
