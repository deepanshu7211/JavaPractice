package multiple_depend;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */
public class MultipleDependTest {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector();

        Person person = injector.getInstance(Person.class);
        person.displayInfo();
    }
}
