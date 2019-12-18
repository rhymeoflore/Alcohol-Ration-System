package in.inzenjer.Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Timeee {

	
	public static String getDate(){
		
		 Calendar cal = Calendar.getInstance();
	      
	        Date date = new Date();
	        SimpleDateFormat simpDate;
	        
	        
	      //  System.out.println("Current Year is : " + cal.get(Calendar.YEAR));
	        // month start from 0 to 11
	       // System.out.println("Current Month is : " + (cal.get(Calendar.MONTH) + 1));
	       // System.out.println("Current Date is : " + cal.get(Calendar.DATE));
	        

	        simpDate = new SimpleDateFormat("hh:mm:ss a");
	        System.out.println(simpDate.format(date));
	        String dt=simpDate.format(date).toString();
			return dt;
	        
	}
	
	
	public static String getDDMMYYYY(){
		
		Date now = new Date(); // java.util.Date, NOT java.sql.Date or java.sql.Timestamp!
		String format1 = new SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.ENGLISH).format(now);
		String format2 = new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH).format(now);
		String format3 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(now);

		System.out.println(format1);
		System.out.println(format2);
		System.out.println(format3);
		return format1;
	}
	 
	
	public static void main(String[] args) {
		getDDMMYYYY();
	}
}
