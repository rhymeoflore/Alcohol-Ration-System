package in.inzenjer.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDifferentExample {
	public static long checkDateDifference(String dateStart, String dateStop) {
	

		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm a");
		//SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm a");

		Date d1 = null;
		Date d2 = null;
		long min = 0;

		try {
			System.out.println("start="+dateStart);
			System.out.println("STOP="+dateStop);
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			min=diffMinutes;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return min;
	}
	
	
	
public static void main(String[] args) {
	System.out.println("mainnnnn");
	String dateStart = "05-14-2001 09:29 PM";
	String dateStop = "05-18-2001 10:31 PM";
	checkDateDifference(dateStart,dateStop);
	
}

}