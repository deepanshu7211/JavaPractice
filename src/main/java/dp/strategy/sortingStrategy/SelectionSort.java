package dp.strategy.sortingStrategy;

import java.util.Arrays;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public class SelectionSort implements SortingStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("Selection Sort!");

        int i, j, first, temp;
        for (i = arr.length - 1; i > 0; i--) {
            first = 0;
            for (j = 1; j <= i; j++) {
                if (arr[j] > arr[first])
                    first = j;
            }
            temp = arr[first];
            arr[first] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
