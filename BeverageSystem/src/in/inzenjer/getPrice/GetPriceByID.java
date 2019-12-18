package in.inzenjer.getPrice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.inzenjer.DBConnection.DBConnection;

public class GetPriceByID {
	public static String getBrandPriceByID(String brndID) {
		ResultSet res = null;

		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select price from stock where brid='" + brndID + "'";
			res = stmt.executeQuery(sql);
			if (res.next()) {
				return res.getString("price");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

}
