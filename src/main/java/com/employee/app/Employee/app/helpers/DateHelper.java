package com.employee.app.Employee.app.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by niyaz on 06.10.2018.
 */
public class DateHelper {

    public final static String DATE_FORMAT = "yyyyMMdd'T'HHmmss";

    public static Date getTime(String timestamp) throws ParseException {
        if (timestamp == null){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date;
        date = dateFormat.parse(timestamp);
        return date;
    }
}
