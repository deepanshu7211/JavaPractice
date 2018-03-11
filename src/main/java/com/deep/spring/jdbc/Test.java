package com.deep.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by deepanshu.saxena on 01/03/16.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_new.xml");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("edao");
        int status = employeeDao.saveEmployee(new Employee("deep", 1000));
        System.out.println("status ::: " + status);
        List<Employee> employeeList = employeeDao.getAllEmployeesRowMapper();
        for (Employee employee : employeeList)
            System.out.println(employee);

    }
}
