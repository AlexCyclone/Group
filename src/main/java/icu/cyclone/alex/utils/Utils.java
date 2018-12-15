package icu.cyclone.alex.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utils {
    public static Calendar toCalendar(String source, String pattern) {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            calendar.setTime(sdf.parse(source));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return calendar;
    }
}
