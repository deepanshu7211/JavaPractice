/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions.sort;

/**
 * @author deepanshu.saxena
 */
public class MergeSortAlgo {
    private static int arr[] = {38, 27, 43, 3, 9, 82, 10};
    ;

    public static void main(String[] args) {

        // printArray(arr);

        mergesort(arr, 0, arr.length - 1);
        printArray(arr, " ");

    }

    public static void printArray(int array[], String name) {
        for (int i = 0; i < array.length; i++)
            System.out.println("name :: " + name + "  " + array[i]);
    }

    public static void mergesort(int arr[], int l, int r) {
        if (l < r) {

            int m = (l + r) / 2;
            //System.out.println(" l r and m " + l +"  " + r + "  " +m  +" "+arr[m]);
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            // printArray(arr, "check");
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        // First array arr[l,m] and second array arr(m+1,r)

        int n1 = m - l + 1;
        int n2 = r - m;
        int k = 0, i = 0, j = 0;
        int L[] = new int[n1], R[] = new int[n2];

        for (i = 0; i < n1; i++) {
            //System.out.println("arr[l+i] " + arr[i]);
            L[i] = arr[l + i];
        }

        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        //printArray(L," left array");
        //printArray(R,"right array");

        i = 0;
        j = 0;
        k = l;

        int res[] = new int[n1 + n2];

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        // printArray(arr, " resulting array .. ");
    }
}
