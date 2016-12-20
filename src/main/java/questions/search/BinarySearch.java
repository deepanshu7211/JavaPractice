/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions.search;

/**
 * @author deepanshu.saxena
 */
public class BinarySearch {
    public static void main(String[] args) {
        // int arr[] = {2, 3, 4,5, 10, 40,100};
        int arr[] = {2, 3, 4, 10, 40};

        linerSearch(arr, 4);
        // binarysearch(arr,0,arr.length-1,10);
        // int index= recursiveBinarySearch(arr,0,arr.length-1,10);
        // System.out.println("number found at index :: " + index);

    }

    public static void linerSearch(int a[], int num) {
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                System.out.println("Number found :: " + num);
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println("Number not found ");

    }

    public static void binarysearch(int arr[], int l, int r, int num) {
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (num == arr[mid]) {
                System.out.println("number found at index :: " + mid);
                break;
            } else if (num > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
    }

    public static int recursiveBinarySearch(int arr[], int l, int r, int num) {
        if (l <= r) {
            int mid = (l + r) / 2;

            if (num == arr[mid]) return mid;

            if (num > arr[mid]) return recursiveBinarySearch(arr, mid + 1, r, num);
            if (num < arr[mid]) return recursiveBinarySearch(arr, l, mid - 1, num);
        }
        return -1;
    }
}
