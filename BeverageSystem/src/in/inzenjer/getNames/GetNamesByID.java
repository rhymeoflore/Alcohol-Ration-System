package in.inzenjer.getNames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.inzenjer.DBConnection.DBConnection;

public class GetNamesByID {

	public static String getBrandNameByID(String brndID) {
		ResultSet res = null;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select brand from stock where brid='" + brndID + "'";
			res = stmt.executeQuery(sql);
			if (res.next()) {
				return res.getString("brand");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	public static String getRumNameByID(String brndID) {
		ResultSet res = null;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select brand from stock where brid='" + brndID + "'";
			res = stmt.executeQuery(sql);
			if (res.next()) {
				return res.getString("brand");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	public static String getWhiskyNameByID(String whiID) {
		ResultSet res = null;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select brand from stock where brid='" + whiID + "'";
			res = stmt.executeQuery(sql);
			if (res.next()) {
				return res.getString("brand");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	public static String getBrandyNameByID(String brandiID) {
		ResultSet res = null;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select brand from stock where brid='" + brandiID + "'";
			res = stmt.executeQuery(sql);
			if (res.next()) {
				return res.getString("brand");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	public static String getLiquorTypeNameByID(String ltypeID) {
		ResultSet res = null;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select ltype from ltype where ltyid='" + ltypeID + "'";
			res = stmt.executeQuery(sql);
			if (res.next()) {
				return res.getString("ltype");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

}
