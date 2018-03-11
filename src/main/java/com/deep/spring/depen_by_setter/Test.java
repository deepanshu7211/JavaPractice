package com.deep.spring.depen_by_setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_new.xml");
        Emp emp = (Emp) context.getBean("emp1");
        emp.show();

    }
}
