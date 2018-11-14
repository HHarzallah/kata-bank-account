package com.hharzallah.katabank.commons;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    // format date
    public static String formatDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        return dateFormat.format(date);
    }

    // format number
    public static String formatNumber(double number){
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(number);
    }
}
