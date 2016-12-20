package dp.decorator;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class Milk extends ComponentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Milk";
    }

    @Override
    public int cost() {
        return beverage.cost() + 5;
    }
}
