package bs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by deepanshu.saxena on 17/03/16.
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n= scanner.nextInt();
        String s = scanner.nextLine();
        String even = "", odd = "";
        Map m = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                even = even + s.charAt(i);
            } else {
                odd = odd + s.charAt(i);
            }
        }

        System.out.println(even + " " + odd);


    }
}
