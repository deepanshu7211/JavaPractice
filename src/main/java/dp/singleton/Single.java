package dp.singleton;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */

public class Single {
    private static Single single;

    private Single() {
    }

    public static Single getInstance() {
        if (single == null) {
            single = new Single();
        }
        return single;
    }

    // For Thread Safe
//    public static Single getInstance()
//    {
//        if(single ==  null)
//        {
//            synchronized (Single.class) {
//                single = new Single();
//            }
//        }
//        return single;
//    }

    public void show() {
        System.out.println("in single show method");
    }
}
