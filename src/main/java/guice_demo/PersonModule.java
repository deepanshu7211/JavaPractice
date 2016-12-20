package guice_demo;

import com.google.inject.AbstractModule;

/**
 * Created by deepanshu.saxena on 17/05/16.
 */
public class PersonModule extends AbstractModule {


    @Override
    protected void configure() {
//        Person person=new Person("deep");
//        bind(Person.class).toInstance(person);
//         bind(PersonInter.class).to(Person.class);    //This is for Interface

        System.out.println("inside configure ");
        bind(Person.class);  //Only Binding Class
        bind(Contact.class);
        bind(Address.class);
    }


//    @Provides @Singleton
//    public Person getPerson()
//    {
////      return new Person(getAddress(),getContact());
//        return new Person();
//    }

//    @Provides @Singleton
//    public Address getAddress()
//    {
//        System.out.println(" inside public getAddress method");
//        return new Address();
//    }
//
//    @Provides @Singleton
//    public Contact getContact()
//    {
//
//        System.out.println(" inside public getContact method");
//        return new Contact();
//    }

}
