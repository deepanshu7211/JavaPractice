package spr.depen_by_const;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_new.xml");
//        Employee employee=(Employee)context.getBean("employee");
//        Emp employee=(Emp)context.getBean("e");
//        employee.show();
//        Question q=(Question)context.getBean("q");
//        q.displayInfo();

        Ques q = (Ques) context.getBean("q1");
        q.displayInfo();
    }
}
