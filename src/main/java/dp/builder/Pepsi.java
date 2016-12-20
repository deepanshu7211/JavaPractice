package dp.builder;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class Pepsi implements Item {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public int cost() {
        return 60;
    }
}
