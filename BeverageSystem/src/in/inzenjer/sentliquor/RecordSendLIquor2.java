package in.inzenjer.sentliquor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.getNames.GetNamesByID;
import in.inzenjer.getPrice.GetPriceByID;

public class RecordSendLIquor2 {

	public static void recordWhiskyData(String outletID, String liqtype, String[] whiskyID,
			ArrayList<HashMap<String, Integer>> whiskylist) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("record whisky list dataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		HashMap<String, Integer> whisky750map=whiskylist.get(0);
		HashMap<String, Integer> whisky375map=whiskylist.get(1);
		HashMap<String, Integer> whisky180map=whiskylist.get(2);
		Connection con=DBConnection.getConnection();
		for (int i = 0; i < whisky750map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(whiskyID[i])+"\n");
			System.out.println("750="+whisky750map.get(whiskyID[i])+"\n");
			System.out.println("375="+whisky375map.get(whiskyID[i])+"\n");
			System.out.println("180="+whisky180map.get(whiskyID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+whiskyID[i]+"','750','"+GetPriceByID.getBrandPriceByID(whiskyID[i])+"','"+whisky750map.get(whiskyID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			RecordSendLiquor.deductCountFromStock(whiskyID[i], whisky750map.get(whiskyID[i]));
		}
		System.out.println("record whisky 375..................");
		for (int i = 0; i < whisky375map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(whiskyID[i])+"\n");
			System.out.println("750="+whisky750map.get(whiskyID[i])+"\n");
			System.out.println("375="+whisky375map.get(whiskyID[i])+"\n");
			System.out.println("180="+whisky180map.get(whiskyID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+whiskyID[i]+"','375','"+GetPriceByID.getBrandPriceByID(whiskyID[i])+"','"+whisky375map.get(whiskyID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			RecordSendLiquor.deductCountFromStock(whiskyID[i], whisky375map.get(whiskyID[i]));
			
			
		}
		System.out.println("record whisky 180..................");
		for (int i = 0; i < whisky180map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(whiskyID[i])+"\n");
			System.out.println("750="+whisky750map.get(whiskyID[i])+"\n");
			System.out.println("375="+whisky375map.get(whiskyID[i])+"\n");
			System.out.println("180="+whisky180map.get(whiskyID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+whiskyID[i]+"','180','"+GetPriceByID.getBrandPriceByID(whiskyID[i])+"','"+whisky180map.get(whiskyID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			RecordSendLiquor.deductCountFromStock(whiskyID[i], whisky180map.get(whiskyID[i]));
			
			
		}

	}

}
