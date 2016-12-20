package bs;

import java.util.Scanner;

/**
 * Created by deepanshu.saxena on 10/06/16.
 */
public class Pyramid {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Size for pyramid");
        int n = scn.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(" *");
            }

            System.out.println();
        }

//        System.out.println(" mirror image");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = n; k >= i; k--) {
                System.out.print(" *");
            }

            System.out.println();
        }
    }
}
