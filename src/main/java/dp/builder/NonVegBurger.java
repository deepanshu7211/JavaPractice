package dp.builder;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class NonVegBurger implements Item {
    @Override
    public String name() {
        return "Non Veg Burger ";
    }

    @Override
    public int cost() {
        return 50;
    }
}
