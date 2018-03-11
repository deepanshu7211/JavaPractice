package com.deep.mongoDb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by deepanshu.saxena on 23/08/16.
 */
public class DateUtility {

    static final int MAX_DOC = 100;

    private static Calendar getCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static Date getDate(Date date) {
        return getCalendar(date).getTime();
    }

    public static Date getNextDate(Date date) {
        Calendar cal = getCalendar(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
}
