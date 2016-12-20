package spr.hib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by deepanshu.saxena on 03/03/16.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_new.xml");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("empdao");
        employeeDao.saveEmployee(new Employee("deepanshu", 10000));
//        System.out.println("status ::: " + status);
        List<Employee> employeeList = employeeDao.getEmployees();
        for (Employee employee : employeeList)
            System.out.println(employee);


    }
}
