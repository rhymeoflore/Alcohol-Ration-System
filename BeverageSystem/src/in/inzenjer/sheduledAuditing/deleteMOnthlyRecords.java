package in.inzenjer.sheduledAuditing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.Time.DateDifferentExample;
import in.inzenjer.Time.Timeee;

public class deleteMOnthlyRecords implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = getAllUsers();
			getAllFOlder(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ResultSet getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from user";
		res = stmt.executeQuery(sql);
		return res;

	}

	private void getAllFOlder(ResultSet rs)
			throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		while (rs.next()) {
			String startDate = "";
			long minutesDiff=0;
			String userID = rs.getString("uid");
			File folder = new File("M:\\Ration\\" + userID);
			File files[] = folder.listFiles();
			ArrayList<Transaction> blocklist = new ArrayList<Transaction>();
			Transaction t=null;
			for (File f : files) {
				if(!f.getName().equals("head.ser")){
					FileInputStream fin = new FileInputStream(f);
					ObjectInputStream in = new ObjectInputStream(fin);
					 t = (Transaction) in.readObject();
					 in.close();
					 fin.close();
					
				}
				
				if (f.getName().equals("t_1.ser")) {
					System.out.println("FIRST NODE");
					startDate = DataEncryption.decryptdata(t.getDate(), Integer.parseInt(userID));
					 minutesDiff = DateDifferentExample.checkDateDifference(startDate, Timeee.getDDMMYYYY());
				}
				
			}
			
			if(minutesDiff>3){
				System.out.println("3 minutes greater so delete chain");
				for (File f : files) {
					if(!f.getName().equals("head.ser")){
						System.out.println("file path="+f.getAbsolutePath());
						
						System.out.println("delete "+f.getName());
						if(f.delete()) 
				        { 
				            System.out.println("File deleted successfully"); 
				        } 
				        else
				        { 
				            System.out.println("Failed to delete the file"); 
				        } 
					}
				}
				resetTransaction(userID);
				
			}
		}
	}

	private void resetTransaction(String userID) throws SQLException {
		// TODO Auto-generated method stub
		int current=0;
		Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String sql="update transaction set trans='"+current+"' where uid='"+userID+"'";
		System.out.println(sql);
		stmt.executeUpdate(sql);
		
	}

}
