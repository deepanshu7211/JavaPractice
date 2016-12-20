package dp.strategy.sortingStrategy;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public class StrategyContext {
    private SortingStrategy sortingStrategy;

    public SortingStrategy getSortingStrategy() {
        return sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortNumbers(int[] arr) {
        sortingStrategy.sort(arr);
    }
}
