package in.inzenjer.sentliquor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.getNames.GetNamesByID;
import in.inzenjer.getPrice.GetPriceByID;

public class RecordSendLiquor3 {

	public static void recordBrandyData(String outletID, String liqtype, String[] brandyID,
			ArrayList<HashMap<String, Integer>> brandylist) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("record brandy list dataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		HashMap<String, Integer> brandy750map=brandylist.get(0);
		HashMap<String, Integer> brandy375map=brandylist.get(1);
		HashMap<String, Integer> brandy180map=brandylist.get(2);
		Connection con=DBConnection.getConnection();
		for (int i = 0; i < brandy750map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(brandyID[i])+"\n");
			System.out.println("750="+brandy750map.get(brandyID[i])+"\n");
			System.out.println("375="+brandy375map.get(brandyID[i])+"\n");
			System.out.println("180="+brandy180map.get(brandyID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+brandyID[i]+"','750','"+GetPriceByID.getBrandPriceByID(brandyID[i])+"','"+brandy750map.get(brandyID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			RecordSendLiquor.deductCountFromStock(brandyID[i], brandy750map.get(brandyID[i]));
		}
		System.out.println("record brandy 375..................");
		for (int i = 0; i < brandy375map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(brandyID[i])+"\n");
			System.out.println("750="+brandy750map.get(brandyID[i])+"\n");
			System.out.println("375="+brandy375map.get(brandyID[i])+"\n");
			System.out.println("180="+brandy180map.get(brandyID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+brandyID[i]+"','375','"+GetPriceByID.getBrandPriceByID(brandyID[i])+"','"+brandy375map.get(brandyID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			RecordSendLiquor.deductCountFromStock(brandyID[i], brandy375map.get(brandyID[i]));
		}
		System.out.println("record brandy 180..................");
		for (int i = 0; i < brandy180map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(brandyID[i])+"\n");
			System.out.println("750="+brandy750map.get(brandyID[i])+"\n");
			System.out.println("375="+brandy375map.get(brandyID[i])+"\n");
			System.out.println("180="+brandy180map.get(brandyID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+brandyID[i]+"','180','"+GetPriceByID.getBrandPriceByID(brandyID[i])+"','"+brandy180map.get(brandyID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			RecordSendLiquor.deductCountFromStock(brandyID[i], brandy180map.get(brandyID[i]));
			
			
		}
	}

}
