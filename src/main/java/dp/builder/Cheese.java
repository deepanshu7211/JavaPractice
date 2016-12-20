package dp.builder;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class Cheese implements Item {
    @Override
    public String name() {
        return "Cheese ";
    }

    @Override
    public int cost() {
        return 20;
    }
}
