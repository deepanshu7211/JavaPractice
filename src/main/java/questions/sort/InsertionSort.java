/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions.sort;

/**
 * @author deepanshu.saxena
 */
public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6};
        insertionsort(arr, arr.length);
    }

    public static void insertionsort(int arr[], int n) {
        int key, j;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            //System.out.println("i value : " + i +" a[i] " + arr[i] + " key :: " + key);
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        System.out.println("sorted array :: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
