package com.cworld.timeline.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeConverter {
	public static final String dateTimeFormat = "yyyy-MM-dd hh:mm:ss.S";

	public static Timestamp toTimeStamp(String stringTime) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
		Date parsedTimeStamp = dateFormat.parse(stringTime);
		Timestamp timestamp = new Timestamp(parsedTimeStamp.getTime());
		return timestamp;
	}
}
