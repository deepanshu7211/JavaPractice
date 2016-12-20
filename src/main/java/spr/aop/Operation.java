package spr.aop;

/**
 * Created by deepanshu.saxena on 01/03/16.
 */
public class Operation {
    public void msg() {
        System.out.println("msg method invoked");
    }

    public int m() {
        System.out.println("m method invoked");
        return 2;
    }

    public int k() {
        System.out.println("k method invoked");
        return 3;
    }
}
