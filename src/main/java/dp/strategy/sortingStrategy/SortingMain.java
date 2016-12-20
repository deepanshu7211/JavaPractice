package dp.strategy.sortingStrategy;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public class SortingMain {
    public static void main(String[] args) {
        int numbers[] = {20, 50, 15, 6, 80};
        StrategyContext strategyContext = new StrategyContext();
        strategyContext.setSortingStrategy(new InsertionSort());
        strategyContext.sortNumbers(numbers);
    }
}
