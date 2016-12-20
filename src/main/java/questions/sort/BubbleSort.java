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
public class BubbleSort {

    public static void main(String[] args) {
        // int arr[] = {64, 34, 25, 12, 22, 11, 90};
        int arr[] = {0, 3, 1, 0, 5, 2, 4, 5, 2};

        System.out.println("length :: " + arr.length);
        bubbleSort(arr, arr.length);
    }

    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("sorted array :: ");

        System.out.println(Arrays.toString(arr));
    }
}
