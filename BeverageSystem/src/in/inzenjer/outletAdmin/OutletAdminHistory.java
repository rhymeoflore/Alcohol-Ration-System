package in.inzenjer.outletAdmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.admin.AdminHistory;

public class OutletAdminHistory {

	public static ArrayList<Transaction> getOutletPurchaseHistory(String bev) throws NumberFormatException, Exception{
		System.out.println("bbbeeevvv="+bev);
		ResultSet uids = AdminHistory.getCompleteUSerID();
		return AdminHistory.processresult(uids, bev);
		
	}
}
