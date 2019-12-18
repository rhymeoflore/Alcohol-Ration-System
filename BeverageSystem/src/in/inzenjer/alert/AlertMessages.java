package in.inzenjer.alert;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.Time.Timeee;

public class AlertMessages {
	

	public static void recordAlertMessages(ArrayList<String> filenames, int[] filenumber, String userID) throws SQLException {
		// TODO Auto-generated method stub
		Iterator<String> itr=filenames.iterator();
		ArrayList<String> detected=new ArrayList<String>();
		while(itr.hasNext()){
			String n=(String)itr.next();
			String num=n.substring(n.lastIndexOf("_"+1));
			int nn=Integer.parseInt(num);
			for (int i = 0; i < filenumber.length; i++) {
				if(nn==filenumber[i]){
					detected.add(n);
					
				}
			}
		}
		System.out.println("deleted block is="+detected);
		recordDeleted(userID,detected);
	}

	private static void recordDeleted(String userID, ArrayList<String> detected) throws SQLException {
		// TODO Auto-generated method stub
		for (int i = 0; i < detected.size(); i++) {
			insert(detected.get(i),userID);
		}
	}

	private static void insert(String blk, String userID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String sql="insert into alert(uid,block,detect_time) values('"+userID+"','"+blk+"','"+Timeee.getDDMMYYYY()+"')";
		int ret=stmt.executeUpdate(sql);
		
	}

}
