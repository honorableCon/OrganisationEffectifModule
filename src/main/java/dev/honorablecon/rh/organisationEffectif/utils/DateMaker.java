package dev.honorablecon.rh.organisationEffectif.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateMaker {
    public static java.util.Date strToDate(String strDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.parse(strDate);
    }

    /* add one year */
    public static java.util.Date addOneYear(java.util.Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        cal.add(java.util.Calendar.YEAR, 1);
        return cal.getTime();
    }
}
