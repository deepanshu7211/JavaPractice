package dp.dp_pz;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */

public class PizzaBuilderTest {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder().withSize(Size.MEDIUM).withCrust(Crust.THIN).withCheese(Cheese.ITALIAN).build();
        System.out.println(pizza);

    }
}
