package dp.builder;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class Coke implements Item {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public int cost() {
        return 60;
    }
}
