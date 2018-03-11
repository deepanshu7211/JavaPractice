package com.deep.spring.auto_wire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_new.xml");
        A a = (A) context.getBean("a");
        a.display();
    }
}
