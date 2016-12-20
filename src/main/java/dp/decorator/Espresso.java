package dp.decorator;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public int cost() {
        return 20;
    }
}
