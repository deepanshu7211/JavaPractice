/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions.sort;

import java.util.Arrays;

/**
 * @author deepanshu.saxena
 */
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        selectionSort(arr, arr.length);
    }

    public static void selectionSort(int arr[], int n) {
        int i, j, min_index = 0;

        for (i = 0; i < n; i++) {
            min_index = i;
            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        System.out.println("sorted array " + Arrays.asList(arr));
        for (i = 0; i < n; i++)
            System.out.println(arr[i]);

    }
}
