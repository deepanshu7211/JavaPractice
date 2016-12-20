package dp.decorator;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Beverage beverage = new Latte();
        beverage = new Milk(beverage);
        beverage = new Chocolate(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
