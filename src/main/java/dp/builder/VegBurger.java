package dp.builder;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class VegBurger implements Item {
    @Override
    public String name() {
        return "Veg Burger ";
    }


    @Override
    public int cost() {
        return 25;
    }
}
