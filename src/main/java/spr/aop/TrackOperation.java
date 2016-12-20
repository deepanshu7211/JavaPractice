package spr.aop;

import org.aspectj.lang.JoinPoint;

/**
 * Created by deepanshu.saxena on 01/03/16.
 */
public class TrackOperation {

    public void myadvice(JoinPoint jp)  // it is an advice
    {
        System.out.println("additional concern ");
    }
}
