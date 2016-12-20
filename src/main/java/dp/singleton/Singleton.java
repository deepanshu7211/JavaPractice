package dp.singleton;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class Singleton {
    public static void main(String[] args) {
        Single single = Single.getInstance();
        Single single1 = Single.getInstance();
        System.out.println(single.equals(single1));
        single.show();
    }
}


