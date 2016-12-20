package bs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 19/02/16.
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("test", "test");

//        list.add("test2");
        Set<String> valueSet = new HashSet<>();
        valueSet.add(map.values().toString());
        System.out.println(valueSet);
        while (true && true) {
            System.out.println("inside");
            break;
        }


        new Test().foo(null);
//        String s1 = "cat";
//
//        String s8 = "c";
//        s8 = s8 + "at";
//        System.out.println(s8);
//        System.out.println(s8==s1);
//        int arr[][]=new int[3][5];
//        for(int i=0;i<3;i++)
//        {
//            for(int j=0;j<arr[i].length;j++)
//            {
//                arr[i][j]=j;
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

//    public void foo(Exception e) {
//        System.out.println("Exception");
//    }

//    public void foo(String s)
//    {
//        System.out.println("String");
//    }

    public void foo(Object o) {
        System.out.println("Object");
    }

    public void foo(RuntimeException re) {
        System.out.println("RuntimeException");
    }
}
