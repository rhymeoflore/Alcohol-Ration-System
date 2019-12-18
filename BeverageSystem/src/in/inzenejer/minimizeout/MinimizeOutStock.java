package in.inzenejer.minimizeout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.verifypurchase.VerifyProduct;

public class MinimizeOutStock {

	public static ArrayList<String> brAndLtID;
	public static ArrayList<String> QTY;

	public static void minimizeOutStockDetails(String userID, String bevID) throws SQLException {
		System.out.println("varifying product");
		System.out.println("MINIMIZING STOCKkkkkkkkkkkkkkkkkkkkkkkkkkk");
		for (int i = 0; i < brAndLtID.size(); i++) {
			System.out.println( brAndLtID.get(i));
			//String brltid[] = brAndLtID.get(i).split("$");
			String brltid[]=new String[2];
			brltid[0]=brAndLtID.get(i).substring(0, brAndLtID.get(i).lastIndexOf("$"));
			brltid[1]=brAndLtID.get(i).substring(brAndLtID.get(i).lastIndexOf("$")+1);
			System.out.println("length="+brltid.length);
			minimize(brltid, bevID, QTY.get(i));

		}

	}

	private static void minimize(String[] brltid, String bevID, String qty) throws SQLException {
		// TODO Auto-generated method stub
		int curent_count = getCurrentCount(brltid, bevID, qty);
		curent_count = curent_count - 1;
		updateCount(curent_count, brltid, bevID, qty);

	}

	private static void updateCount(int curent_count, String[] brltid, String bevID, String qty) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql = "update outstock set count='" + curent_count + "' where oid='" + bevID + "' and ltyid='"
				+ brltid[1] + "' and brid='" + brltid[0] + "'";
		System.out.println(sql);
		int ret = stmt.executeUpdate(sql);

	}

	private static int getCurrentCount(String[] brltid, String bevID, String qty) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("get current count");
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select count from outstock where oid='" + bevID + "' and ltyid='" + brltid[1] + "' and brid='"
				+ brltid[0] + "' and quantity='" + qty + "'";
		System.out.println(sql);
		ResultSet res = stmt.executeQuery(sql);
		if (res.next()) {
			return Integer.parseInt(res.getString("count"));
		}
		return 0;

	}
}
