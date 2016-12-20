package multiple_depend;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */
public class Laptop {
    private String model;
    private int price;

    public Laptop() {
        this.model = "hp";
        this.price = 12345;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
