package dp.dp_pz;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public enum Cheese {

    AMERICAN(40),
    ITALIAN(60);

    private int cost;

    private Cheese(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
