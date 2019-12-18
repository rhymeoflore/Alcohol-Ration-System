package in.inzenjer.user;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.admin.AdminDAO;
import in.inzenjer.company.Company;

public class UserDAO {

	public static String USERNAME;
	public static int PASSWORD;

	public static int updateProfile(HttpServletRequest req, HttpSession ses) {
		int ret = 0;
		Connection con = DBConnection.getConnection();
		Statement stmt;
		UserBean ub = (UserBean) ses.getAttribute("userdetails");
		try {
			stmt = con.createStatement();
			String sql = "update company set com_ceo='" + req.getParameter("ceo") + "',com_name='"
					+ req.getParameter("cname") + "',com_address='" + req.getParameter("caddress") + "',com_industry='"
					+ req.getParameter("ind") + "',com_country='" + req.getParameter("con") + "',com_phone='"
					+ req.getParameter("ph") + "',com_email='" + req.getParameter("email") + "' where id='" + ub.getId()
					+ "'";
			ret = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;

	}

	public static int insertCompany(Company comp) {
		// TODO Auto-generated method stub
		int ret = 0;
		Connection con = DBConnection.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into dataowner(com_ceo,com_name,com_address,com_industry,com_country,com_phone,com_email,com_userID,com_password,com_status) values('"
					+ comp.getCEO() + "','" + comp.getC_name() + "','" + comp.getC_address() + "','"
					+ comp.getC_industry() + "','" + comp.getC_country() + "','" + comp.getC_phone() + "','"
					+ comp.getC_email() + "','" + comp.getC_userid() + "','" + comp.getC_passwordss() + "','Active')";

			ret = stmt.executeUpdate(sql);
			ResultSet rs = stmt.getGeneratedKeys();
			ret = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;

	}

	public static ResultSet authenticatingUser(String username, String password, String utype, String org) {
		Connection con = DBConnection.getConnection();
		Statement stmt;
		ResultSet rs = null;
		String sql = null;

		if (utype.equals("ADMIN")) {
			sql = "select * from admin where email='" + username + "' and password='" + password + "'";

		} else if (utype.equals("OWNER")) {
			sql = "select * from dataowner where com_userID='" + username + "' and com_password='" + password
					+ "' and com_status='Active'";

			System.out.println("PPPPPPPPPPPPPPPP");
		} else if (utype.equals("OUTLET")) {
			sql = "select * from outletadmin where email='" + username + "' and password='" + password + "'";
			System.out.println(sql);

		} else if (utype.equals("USER")) {
			sql = "select * from datauser where username='" + username + "' and password='" + password + "' and owner='"
					+ org + "'";

		} else if (utype.equals("PROXY")) {
			sql = "select * from user where email='" + username + "' and password='" + password + "' and usertype='"
					+ utype + "'";

		}

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static String getServer(int user) {
		String server = null;
		Connection con = DBConnection.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select mapid from servermapping where uid='" + user + "'";
			ResultSet res = stmt.executeQuery(sql);
			if (res.next()) {
				server = res.getString("mapid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return server;

	}

	public static ResultSet getAllGroupsForSpecificUser(int user, String server) {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		System.out.println("server=" + server);
		System.out.println("userrrrrrrr=" + user);
		try {
			stmt = con.createStatement();
			String sql = "select * from grp where g_owner='" + user + "'";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
			return res;
		}

		return res;
	}

	public static ResultSet getAllGroupsForSpecificDataUser(int user, String server) {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		System.out.println("server=" + server);
		System.out.println("userrrrrrrr=" + user);
		try {
			stmt = con.createStatement();
			String sql = "select * from grpmember where u_id='" + user + "'";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
			return res;
		}

		return res;
	}

	public static ResultSet getAllUsers() {
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from company";
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}

	private static ArrayList<String> filterServer(ArrayList<String> servers) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<String> filteredServer = new ArrayList<String>();
		for (int i = 0; i < servers.size(); i++) {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			boolean flag = false;
			while (rs.next()) {
				System.out.println("data=" + rs.getString(3));
				if (rs.getString("TABLE_NAME").equals("grp")) {
					flag = true;
					filteredServer.add(servers.get(i));
				}

			}

		}

		return filteredServer;
	}

	public static ResultSet getALLDownloadableFilesForUser(String server, String gp) {
		ResultSet r = null;
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT bid,dataname,share from data_names where share like '%" + gp + "%'";
			r = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public static ResultSet getspecificfileForDownload(String server, String file) {
		ResultSet r = null;
		System.out.println("FILE=" + file);
		int f = Integer.parseInt(file);
		System.out.println("fileeeeeeeeeeeeeeeee=" + file);
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT data_id,block FROM block_1 WHERE bid='" + f
					+ "' UNION SELECT data_id,block FROM block_2 WHERE bid='" + f
					+ "' UNION SELECT data_id,block FROM block_3 where bid='" + f + "'";

			r = stmt.executeQuery(sql);
			r.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public static int deleteGroup(String gpid, int userID) throws SQLException {
		int ret = 0;
		System.out.println("group deleteion called");
		System.out.println("grpId=" + gpid);
		Connection con = DBConnection.getConnection();
		String deletemember = "delete from grpmember where g_id='" + gpid + "'";
		String deletegroup = "delete from grp where g_id='" + gpid + "'";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(deletegroup);
		Statement stm = con.createStatement();
		stm.executeUpdate(deletemember);
		return ret;

	}

	public static ResultSet getDataUsers(int ownerID) {
		ResultSet r = null;
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT * from datauser where owner='" + ownerID + "'";
			r = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;

	}

	public static int deleteDataUSer(int ownerID, String userID) {
		int r = 0;
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "DELETE from datauser where owner='" + ownerID + "' and dt_uid='" + userID + "'";
			r = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;

	}

	public static ResultSet OwnergetAllGroups(String server) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		con = DBConnection.getConnection();
		String sql = "select * from grp";
		stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(sql);

		return res;
	}

}
