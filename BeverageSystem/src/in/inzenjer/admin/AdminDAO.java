package in.inzenjer.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import in.inzenjer.DBConnection.DBConnection;

import in.inzenjer.user.UserRegistration;

public class AdminDAO {

	public static String[] getMetaData(ResultSet r) {
		String a[] = null;

		try {
			ResultSetMetaData meta = r.getMetaData();

			int col = meta.getColumnCount();
			a = new String[col];
			for (int i = 0; i < col; i++) {
				System.out.println(meta.getColumnName(1));
				a[i] = meta.getColumnName(i + 1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;
	}

	public static int addOutLet(String bevID, String place, String villg, String taluk, String dist, String ph,
			String email, String uname, String pwd) {
		int ret = 0;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into outlet (bevid,place,village,taluk,district,phone,email,username,password) values('"
					+ bevID + "','" + place + "','" + villg + "','" + taluk + "','" + dist + "','" + ph + "','" + email
					+ "','" + uname + "','" + pwd + "')";

			ret = stmt.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ret;

	}
	//public static int addUser(String fn, String ln, String ag, String gen, String addr, String phone,String bev) {
	public static int addUser(FileItem photo,HashMap<String, String> map) throws Exception {
		int ret = 0;
		
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			
			stmt = con.createStatement();
			
			
			String sql = "insert into user (bid,firstname,lastname,age,gender,address,phone) values('"+map.get("bev")+"','" + map.get("fn") + "','" + map.get("ln")
					+ "','" + map.get("ag") + "','" + map.get("gen") + "','" + map.get("addr") + "','" + map.get("ph") + "')";
			
			ret = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			ResultSet rs=stmt.getGeneratedKeys();
			if(rs.next()){
				ret=rs.getInt(1);
			}
			uploadPHOTO(ret,photo);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ret;

	}
	
	public static void uploadPHOTO(int genID, FileItem photofile) throws Exception{
		File f=new File("M:/Ration/UserPhotos/"+genID+".jpg");
		if(!f.exists()){
			f.createNewFile();
		}
		photofile.write(f);
		
	}

	public static ResultSet getAllUser() {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from user";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}
	public static ResultSet getAllUserFromOtherOutLet(String bevID) {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from user where bid!='"+bevID+"'";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}

	public static ResultSet getAllType() {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from ltype";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;

	}

	public static int addLiquorDetails(String typ,String brnd,String qty,String pri,String bottle) {
		int ret = 0;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql ="insert into stock(type,brand,quantity,price,count) values('"+typ+"','"+brnd+"','"+qty+"','"+pri+"','"+bottle+"')";
			ret = stmt.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ret;

	}
	
	public static ResultSet getAllStockDeatils() {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from stock";
			System.out.println(sql);
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;

	}

	/***********************************************************************************************************************///
	public static ResultSet authenticatingCEO(String username, String password) {
		Connection con = DBConnection.getConnection();
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String sql = "select * from admin where username='" + username + "' and password='" + password + "'";

			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet getAllOutLets() {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select * from outlet";
			res = stmt.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}

	public static int deleteOutLet(String outletID) {
		int ret = 0;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from outlet where id='" + outletID + "'";

			ret = stmt.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ret;

	}

	public static int deleteUser(String userID) {
		int ret = 0;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from user where uid='" + userID + "'";

			ret = stmt.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ret;

	}

}
