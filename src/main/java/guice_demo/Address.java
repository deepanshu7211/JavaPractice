package guice_demo;

/**
 * Created by deepanshu.saxena on 17/05/16.
 */

//@Singleton
public class Address {
    private String city;

    public Address() {
        this.city = "agra";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
