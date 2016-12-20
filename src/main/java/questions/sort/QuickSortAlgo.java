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

public class QuickSortAlgo {

    public static void main(String[] args) {
        MyQuickSort sorter = new MyQuickSort();
        //int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        int[] input = {10, 7, 8, 9, 1, 5, 3};
        // int input[]={0, 3, 1, 0, 5, 2, 4, 5, 2};
        sorter.sort(input);
        System.out.println("sorted array " + Arrays.toString(input));

    }

}

class MyQuickSort {
    private int[] in;
    private int length;

    public void sort(int[] input) {
        this.in = input;
        length = input.length;
        quicksort(0, length - 1);
    }

    private void quicksort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = in[lowerIndex + (higherIndex - lowerIndex) / 2];
//        System.out.println(" pivot :: " + pivot);
//        System.out.println(" a[j] " + in[j]);

        while (i <= j) {

            while (in[i] < pivot) {
                //System.out.println(" i " + i + "  " + in[i]);
                i++;
            }
            while (in[j] > pivot)
                j--;

            if (i <= j) {
                System.out.println(" exchange :: " + i + " j :: " + j);
                System.out.println(" exchange values :: " + in[i] + " j :: " + in[j]);
                exchangenumber(i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j)
            quicksort(lowerIndex, j);
        if (i < higherIndex)
            quicksort(i, higherIndex);

    }

    private void exchangenumber(int i, int j) {
        int temp = in[i];
        in[i] = in[j];
        in[j] = temp;
    }


}
