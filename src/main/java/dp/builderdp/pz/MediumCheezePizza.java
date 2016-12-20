package dp.builderdp.pz;

/**
 * Created by deepanshu.saxena on 24/02/16.
 */
public class MediumCheezePizza extends Veg_Pizza {
    @Override
    public String name() {
        return "cheeze pizza";
    }

    @Override
    public String size() {
        return "medium";
    }

    @Override
    public int price() {
        return 200;
    }
}
