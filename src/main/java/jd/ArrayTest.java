package jd;

/**
 * Created by deepanshu.saxena on 20/03/16.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int arr[][] = new int[2][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
