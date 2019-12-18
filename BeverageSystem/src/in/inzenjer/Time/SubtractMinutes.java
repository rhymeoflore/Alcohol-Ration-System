package in.inzenjer.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class SubtractMinutes {
	public static String minuteToBack(String startDate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		//String currentDate="05-14-2001 09:29 PM";
		String currentDate=startDate;
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm a");
		Date d1 = formatter.parse(currentDate);
		Calendar gc = new GregorianCalendar();
		gc.setTime(d1);
		gc.add(Calendar.MINUTE, -3);
		Date d2 = gc.getTime();
		String format1 = new SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.ENGLISH).format(d2);
	    System.out.println("After 30 minutes subtraction from date: "+format1);
	    return format1;
		
	}
	public static void main(String[] args) throws ParseException {
		String currentDate="05-14-2001 09:29 PM";
		minuteToBack(currentDate);
	}

}
