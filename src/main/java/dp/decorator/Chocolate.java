package dp.decorator;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class Chocolate extends ComponentDecorator {
    private Beverage beverage;

    public Chocolate(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Chocolate";
    }

    @Override
    public int cost() {
        return beverage.cost() + 10;
    }
}
