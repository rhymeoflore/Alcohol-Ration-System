package in.inzenjer.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlockChain.User;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.outletAdmin.OutletAdminDAO;

public class AdminHistory {

	public static User u[];

	public static ArrayList<Transaction> getPurchaseHistory(String bev) throws Exception {
		ResultSet uids = getCompleteUSerID();
		int a = 0;
		return processresult(uids, bev);
	}

	public static ArrayList<Transaction> processresult(ResultSet uids, String bev) throws Exception {
		// TODO Auto-generated method stub
		// u=new ArrayList<User>();
		ArrayList<User> ulist = new ArrayList<User>();
		ArrayList<Transaction> tlist = new ArrayList<Transaction>();
		while (uids.next()) {
			File folder = new File("M:\\Ration\\" + uids.getString("uid"));
			File files[] = folder.listFiles();
			for (File f : files) {
				if (!f.getName().equals("head.ser")) {
					System.out.println("file path=" + f.getAbsolutePath());
					FileInputStream fin = new FileInputStream(f);
					ObjectInputStream in = new ObjectInputStream(fin);
					Transaction pp = (Transaction) in.readObject();
					String bevID = DataEncryption.decryptdata(pp.getBevid(), Integer.parseInt(uids.getString("uid")));
					if (bevID.equals(bev)) {
						pp.setBevid(DataEncryption.decryptdata(pp.getBevid(), Integer.parseInt(uids.getString("uid"))));
						pp.setDate(DataEncryption.decryptdata(pp.getDate(), Integer.parseInt(uids.getString("uid"))));
						pp.setTid(DataEncryption.decryptdata(pp.getTid(), Integer.parseInt(uids.getString("uid"))));
						String ar[] = pp.getProducts();
						for (int i = 0; i < ar.length; i++) {
							ar[i] = DataEncryption.decryptdata(ar[i], Integer.parseInt(uids.getString("uid")));
						}
						pp.setProducts(ar);
						tlist.add(pp);
						ulist.add(getUserObjectByID(uids.getString("uid")));

					}

					// System.out.println(DataEncryption.decryptdata(pp.getDate(),
					// 1));
					// System.out.println(DataEncryption.decryptdata(pp.getTid(),
					// 1));
					// System.out.println(DataEncryption.decryptdata(pp.getBevid(),
					// 1));
				}
			}

		}
		u=new User[ulist.size()];
		for (int i = 0; i < ulist.size(); i++) {
			u[i]=ulist.get(i);
		}
		return tlist;

	}

	public static ResultSet getCompleteUSerID() {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select uid from user";
			res = stmt.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return res;
	}

	public static User getUserObjectByID(String userID) {
		ResultSet res = null;
		User u = new User();
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select * from user where uid='" + userID + "'";
			res = stmt.executeQuery(sql);
			if (res.next()) {
				u.setFirstname(res.getString("firstname"));
				u.setLastname(res.getString("lastname"));
				u.setAddress(res.getString("address"));
				u.setAge(res.getString("age"));
				u.setGender(res.getString("gender"));
				u.setPhone(res.getString("phone"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return u;
	}

}
