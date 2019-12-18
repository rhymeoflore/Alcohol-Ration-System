package in.inzenjer.Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TT {

	
	public static String getDate(){
		
		 Calendar cal = Calendar.getInstance();
	      
	        Date date = new Date();
	        SimpleDateFormat simpDate;

	        simpDate = new SimpleDateFormat("hh:mm:ss a");
	        System.out.println(simpDate.format(date));
	        String dt=simpDate.format(date).toString();
			return dt;
	        
	}
	public static void main(String[] args) {
		getDate();
	}
}
