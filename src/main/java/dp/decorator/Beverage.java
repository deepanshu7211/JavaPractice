package dp.decorator;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public abstract class Beverage {
    String description = "Unkown";

    public String getDescription() {
        return description;
    }

    public abstract int cost();
}
