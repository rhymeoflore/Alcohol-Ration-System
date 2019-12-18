package in.inzenjer.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

	static Connection con;
	static Statement stmt;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rationsystem", "root", "pass");
			// stmt=con.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
public static void main(String[] args) {
	getConnection();
}

}
