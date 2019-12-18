package in.inzenjer.profile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.inzenjer.DBConnection.DBConnection;

public class Profile {
	
	public static ResultSet getProfile(int user) {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		
		System.out.println("userrrrrrrr=" + user);
		try {
			stmt = con.createStatement();
			String sql = "select * from company where id='" + user + "'";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
			return res;
		}

		return res;
		
	}

}
