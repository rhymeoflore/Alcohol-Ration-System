package in.inzenjer.updatepassword;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.inzenjer.DBConnection.DBConnection;

public class UpdatePassword {

	public static int updateNewPassword(String pass, int userid, String type) {
		int ret = 0;

		Connection con = DBConnection.getConnection();
		Statement stmt;
		ResultSet rs = null;
		String sql = null;
		if (type.equals("cloud")) {
			sql = "update admin set password='" + pass + "' where uid='" + userid + "'";
		}else if (type.equals("outlet")) {
			sql = "update outletadmin set password='" + pass + "' where id='" + userid + "'";
		}

		try {
			stmt = con.createStatement();

			ret = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

}
