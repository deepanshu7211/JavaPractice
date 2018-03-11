package com.deep.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Main {
    public static void main(String[] args) {
//        Resource resource=new ClassPathResource("spring_new.xml");
//        BeanFactory factory=new XmlBeanFactory(resource);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_new.xml");
        Student student = (Student) context.getBean("student");
        student.displayInfo();
    }
}
