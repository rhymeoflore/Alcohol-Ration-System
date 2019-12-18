package in.inzenjer.outletAdmin;

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
import in.inzenjer.DBConnection.DBConnection;

public class OutletAdminDAO {
	public static ResultSet getAllStockDeatils(String outletID) {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from outstock where oid='"+outletID+"'";
			System.out.println(sql);
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;

	}
	
	public static ResultSet getUSerDeatilsByOutlet(String outletID) {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from user where bid='"+outletID+"'";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;

	}
	public static ResultSet getUSerDeatilsByUSerID(String userID) {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from user where uid='"+userID+"'";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;

	}
	public static void getAllPurchasedetails() throws IOException, ClassNotFoundException{
		File folder = new File("M:\\Ration\\");
		File files[] = folder.listFiles();
		ArrayList<Transaction> blocklist=new ArrayList<Transaction>();
		for (File f : files) {
			if(!f.getName().equals("head.ser")){
				FileInputStream fin = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(fin);
				Transaction t = (Transaction) in.readObject();
				
			}else{
				
			}
			
			//blocklist.add(t);
			
			}
	}
	public static boolean checkIfBanned(String userID) {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		boolean result=false;

		try {
			stmt = con.createStatement();
			String sql = "select *from transaction where uid='"+userID+"' and trans='-1'";
			res = stmt.executeQuery(sql);
			if(res.next()){
				result= true;
			}else{
				result= false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}
}
