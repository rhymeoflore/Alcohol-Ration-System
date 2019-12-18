package in.inzenjer.outletAdmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlockChain.User;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.admin.AdminDAO;
import in.inzenjer.admin.AdminHistory;

public class ViewUser {

	public static ArrayList<User> getPurchasedUser(String bevID) throws NumberFormatException, Exception {
		ResultSet uids = AdminHistory.getCompleteUSerID();	
		return getUserDetails(uids,bevID);
	}

	private static ArrayList<User> getUserDetails(ResultSet uids, String bevID) throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		ArrayList<User> ulist = new ArrayList<User>();
		while (uids.next()) {
			File folder = new File("M:\\Ration\\" + uids.getString("uid"));
			File files[] = folder.listFiles();
			for (File f : files) {
				if (!f.getName().equals("head.ser")) {
					System.out.println("file path=" + f.getAbsolutePath());
					FileInputStream fin = new FileInputStream(f);
					ObjectInputStream in = new ObjectInputStream(fin);
					Transaction pp = (Transaction) in.readObject();
					String bev = DataEncryption.decryptdata(pp.getBevid(), Integer.parseInt(uids.getString("uid")));
					if (bevID.equals(bev)) {
						ulist.add(AdminHistory.getUserObjectByID(uids.getString("uid")));
						break;
					}
				}
			}
			
		}
		return ulist;
	}

	
}
