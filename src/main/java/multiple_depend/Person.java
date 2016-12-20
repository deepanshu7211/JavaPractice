package multiple_depend;

import com.google.inject.Inject;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */

public class Person {
    private Mobile mobile;
    private Laptop laptop;


    public Person() {
    }


    @Inject
    // it will tell Guice to Look which constructor and will automatically generate both object mobile and laptop
    public Person(Mobile mobile, Laptop laptop) {
        this.mobile = mobile;
        this.laptop = laptop;
    }

    public void displayInfo() {
        System.out.println(mobile);
        System.out.println(laptop);
    }
}
