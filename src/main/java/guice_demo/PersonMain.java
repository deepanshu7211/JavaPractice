package guice_demo;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by deepanshu.saxena on 17/05/16.
 */
public class PersonMain {
    public static void main(String[] args) {
//        Person person1=new Person("deep");
        Injector injector = Guice.createInjector(new PersonModule());
//        Person person= (Person) injector.getInstance(PersonInter.class);
        Person person = injector.getInstance(Person.class);
        System.out.println(person);


//        Person person1=(Person)injector.getInstance(PersonInter.class);
//        Person person1=injector.getInstance(Person.class);
//        System.out.println(person1);
//        System.out.println("address is equal or not " + person.getAddress().equals(person1.getAddress()));
//        System.out.println(" person equals or not " + person.equals(person1));
//        System.out.println("contact is equal or not " + person.getContact().equals(person1.getContact()));
    }
}
