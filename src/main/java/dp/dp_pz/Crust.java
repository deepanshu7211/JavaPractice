package dp.dp_pz;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public enum Crust {

    THIN(100),
    STUFFED(200);

    private int cost;

    Crust(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
