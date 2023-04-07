package Util;

import java.sql.Timestamp;
import java.util.Date;

public class DateParsor {
	
	public static Timestamp parseTimestamp(String date) {
		Timestamp timestamp = null;
		
//		1.  
//		new Timestamp(System.currentTimeMillis())
		
//		2.
//		Date now = new Date(2023, 4, 7, 18, 16, 0);
//		timestamp = new Timestamp(now.getTime());
		
//		date : yyyy-mm-ddThh:mm
		
		int year = Integer.parseInt(date.substring(0, 4)) -1900;
		int month = Integer.parseInt(date.substring(5,7)) -1;
		int day = Integer.parseInt(date.substring(8,10));
		int hour = Integer.parseInt(date.substring(11,13));
		int min = Integer.parseInt(date.substring(14,16));
		
		Date target = new Date(year, month, day, hour, min);
		timestamp = new Timestamp(target.getTime());
		
		return timestamp;
	}

}
