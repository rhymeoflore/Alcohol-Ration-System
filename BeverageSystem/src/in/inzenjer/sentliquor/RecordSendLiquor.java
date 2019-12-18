package in.inzenjer.sentliquor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.getCount.GetCountByID;
import in.inzenjer.getNames.GetNamesByID;
import in.inzenjer.getPrice.GetPriceByID;

public class RecordSendLiquor {

	public static void recordBeerData(String outletID, String liqtype, String[] beerID, ArrayList<HashMap<String, Integer>> beerlist) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("record beer list dataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa=");
		HashMap<String, Integer> beermap=beerlist.get(0);
		System.out.println("BEERA MAP SIZE="+beermap.size());
		Connection con=DBConnection.getConnection();
		for (int i = 0; i < beermap.size(); i++) {
			System.out.println(GetNamesByID.getBrandNameByID(beerID[i])+"="+beermap.get(beerID[i]));
			Statement stmt=con.createStatement();
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+beerID[i]+"','NAN','"+GetPriceByID.getBrandPriceByID(beerID[i])+"','"+beermap.get(beerID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			deductCountFromStock(beerID[i],beermap.get(beerID[i]));
			
			
		}
		
		
	}

	public static void deductCountFromStock(String brandID,Integer count) throws SQLException {
		// TODO Auto-generated method stub
		int c=Integer.parseInt(GetCountByID.getBrandCountByID(brandID));
		System.out.println("Count="+c);
		int deductedCount=c-count;
		Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String sql="update stock set count='"+deductedCount+"' where brid='"+brandID+"'";
		stmt.executeUpdate(sql);
		
		
	}

	public static void recordRumData(String outletID, String liqtype, String[] rumID,
			ArrayList<HashMap<String, Integer>> rumlist) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("record rum list dataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		HashMap<String, Integer> rum750map=rumlist.get(0);
		HashMap<String, Integer> rum375map=rumlist.get(1);
		HashMap<String, Integer> rum180map=rumlist.get(2);
		Connection con=DBConnection.getConnection();
		System.out.println("750 size="+rum750map.size());
		for (int i = 0; i < rum750map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(rumID[i])+"\n");
			System.out.println("750="+rum750map.get(rumID[i])+"\n");
			System.out.println("375="+rum375map.get(rumID[i])+"\n");
			System.out.println("180="+rum180map.get(rumID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+rumID[i]+"','750','"+GetPriceByID.getBrandPriceByID(rumID[i])+"','"+rum750map.get(rumID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			deductCountFromStock(rumID[i],rum750map.get(rumID[i]));
			
			
		}
		System.out.println("record rum 375..................");
		for (int i = 0; i < rum375map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(rumID[i])+"\n");
			System.out.println("750="+rum750map.get(rumID[i])+"\n");
			System.out.println("375="+rum375map.get(rumID[i])+"\n");
			System.out.println("180="+rum180map.get(rumID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+rumID[i]+"','375','"+GetPriceByID.getBrandPriceByID(rumID[i])+"','"+rum375map.get(rumID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			deductCountFromStock(rumID[i],rum375map.get(rumID[i]));
			
			
		}
		System.out.println("record rum 180..................");
		for (int i = 0; i < rum180map.size(); i++) {
			Statement stmt=con.createStatement();
			System.out.println(GetNamesByID.getRumNameByID(rumID[i])+"\n");
			System.out.println("750="+rum750map.get(rumID[i])+"\n");
			System.out.println("375="+rum375map.get(rumID[i])+"\n");
			System.out.println("180="+rum180map.get(rumID[i])+"\n");
			String sql="insert into outstock (oid,ltyid,brid,quantity,price,count) values('"+outletID+"','"+liqtype+"','"+rumID[i]+"','180','"+GetPriceByID.getBrandPriceByID(rumID[i])+"','"+rum180map.get(rumID[i])+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			deductCountFromStock(rumID[i],rum180map.get(rumID[i]));
			
			
		}
	}
	
}
