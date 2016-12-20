package dp.builderdp.pz;

/**
 * Created by deepanshu.saxena on 24/02/16.
 */
public class SmallPepsi extends Pepsi {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public String size() {
        return "250 ml pepsi";
    }

    @Override
    public int price() {
        return 25;
    }
}
