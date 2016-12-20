package dp.dp_pz;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */

public class Pizza {

    private int totalPrice = 0;

    private Size size;

    private Crust crust;

    private Cheese cheese;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addToPrice(int price) {
        this.totalPrice = totalPrice + price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "totalPrice=" + totalPrice +
                ", size=" + size +
                ", crust=" + crust +
                ", cheese=" + cheese +
                '}';
    }
}
