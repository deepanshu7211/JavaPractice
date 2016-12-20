package dp.builderdp.pz;

/**
 * Created by deepanshu.saxena on 24/02/16.
 */
public class PizzaDemo {
    public static void main(String[] args) {
        // TODO code application logic here

        OrderBuilder builder = new OrderBuilder();

        OrderedItems orderedItems = builder.buildPizza();

        orderedItems.showItems();

        System.out.println("\n");
        System.out.println("Total Cost : " + orderedItems.cost());

    }
}
