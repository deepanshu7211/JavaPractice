package dp.builderdp.pz;

/**
 * Created by deepanshu.saxena on 24/02/16.
 */
public class SmallCheezePizza extends Veg_Pizza {
    @Override
    public String name() {
        return "Cheeze pizza";
    }

    @Override
    public String size() {
        return "small";
    }

    @Override
    public int price() {
        return 100;
    }
}
