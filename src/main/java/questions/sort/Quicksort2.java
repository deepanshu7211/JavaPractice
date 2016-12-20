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
public class Quicksort2 {

    public static void main(String[] args) {
        int[] input = {10, 7, 8, 9, 1, 5, 10};
        Quicksort2 quicksort2 = new Quicksort2();
        MyQuickSort2 myQuickSort2 = new MyQuickSort2(input);
//        quicksort2.quicksort(input, 0, input.length - 1);
        System.out.println("sorted array :: " + Arrays.toString(input));
    }


}

class MyQuickSort2 {
    int arr[];
    int length;

    public MyQuickSort2(int input[]) {
        this.arr = input;
        length = input.length - 1;
        quicksort(arr, 0, length);

    }

    public void quicksort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);

        }
    }

    private int partition(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        int pivot = arr[(low + (high - low)) / 2];
//        int pivot = arr[left];
        System.out.println("pivot ::  " + pivot);
        while (left <= right) {
            while (arr[left] < arr[pivot]) {
                left++;
            }
            while (arr[right] > arr[pivot]) {
                right--;
            }

            System.out.println(" low ::  " + low + " high :: " + high);
            if (left <= right) {
                exchangenumber(arr, left, right);
                left++;
                right--;

            }
        }
//        arr[left] = arr[right];
//        arr[right] = pivot;

        return right;
    }

    private void exchangenumber(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
