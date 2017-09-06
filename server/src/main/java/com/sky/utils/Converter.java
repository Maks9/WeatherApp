package com.sky.utils;

import com.sky.exceptions.ParseDateException;

import java.text.SimpleDateFormat;

/**
 * Created by fmandryka on 06.09.2017.
 */
public class Converter {
    private String unixToDate(String unix_timestamp) throws ParseDateException {
        long timestamp = Long.parseLong(unix_timestamp) * 1000;

        SimpleDateFormat sdf = new SimpleDateFormat("MMM d H:mm");
        String date = sdf.format(timestamp);

        return date.toString();
    }
}
