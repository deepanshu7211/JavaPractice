package dp.builder;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class OrderMain {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new VegBurger());
        order.addItem(new Cheese());
        order.addItem(new Coke());

        System.out.println("Total Bill :: " + order.totalCost());
        order.showItems();


    }

}
