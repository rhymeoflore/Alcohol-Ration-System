package in.inzenjer.getCount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.inzenjer.DBConnection.DBConnection;

public class GetCountByID {
	public static String getBrandCountByID(String brandID) {
		ResultSet res = null;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select count from stock where brid='" + brandID + "'";
			res = stmt.executeQuery(sql);
			if (res.next()) {
				return res.getString("count");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

}
