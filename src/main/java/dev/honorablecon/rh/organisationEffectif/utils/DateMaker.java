package dev.honorablecon.rh.organisationEffectif.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateMaker {
    public static java.util.Date strToDate(String strDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        return formatter.parse(strDate);
    }
}
