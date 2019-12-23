package com.cognizant.truyum.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Date convertToDate(String date) throws ParseException {
		Date d = sdf.parse(date);
		return d;
	}

	public static String convertToString(Date date) {
		return sdf.format(date);
	}

}
