package dp.strategy.sortingStrategy;

import java.util.Arrays;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public class InsertionSort implements SortingStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("Insertion Sort!");

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; (j >= 0) && (arr[j] > temp); j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
