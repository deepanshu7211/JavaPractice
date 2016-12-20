package dp.dp_pz;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public enum Size {
    SMALL(100),
    MEDIUM(200);

    private int cost;

    Size(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
