package utilities;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtility {
	public static String getUserLoginDate(String format) {
		DateFormat dateformat = new SimpleDateFormat(format);
		Date currentdate = new Date();                          
		return dateformat.format(currentdate);
	}

}
