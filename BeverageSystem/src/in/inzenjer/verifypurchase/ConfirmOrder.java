package in.inzenjer.verifypurchase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.inzenejer.minimizeout.MinimizeOutStock;
import in.inzenjer.BlockChain.Block;
import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.Time.Timeee;

public class ConfirmOrder {

	public static void recordCOnfirm(String userID,String bevID) throws NumberFormatException, Exception {
		File folder = new File("M:\\Ration\\" + userID);
		File files[] = folder.listFiles();
		int blocknumber = 0;
		for (File f : files) {
			String name = f.getName();
			if (name.equals("head.ser")) {

			} else {
				blocknumber = blocknumber + 1;
			}

		}
		SecureRandom random = new SecureRandom();
		String TransID = new BigInteger(80, random).toString(32).toUpperCase();
		String time=Timeee.getDDMMYYYY();
		if(blocknumber>0){
			int prevHash=getPreviousHash(userID,blocknumber);
			Transaction t=new Transaction(TransID,VerifyProduct.prod, time,prevHash,bevID);
			serialize(t,blocknumber+1,userID);
			
		}else{
			Transaction t=new Transaction(TransID,VerifyProduct.prod, time,0,bevID);
			serialize(t,blocknumber+1,userID);
		}
		updateTransactionCount(userID);
		MinimizeOutStock.minimizeOutStockDetails(userID,bevID);
	}
	private static void updateTransactionCount(String userID) throws SQLException {
		System.out.println("updating Transactionnnnnnnnnnnnnnnnnnnnnnnn");
		// TODO Auto-generated method stub
		int current=getcurrentCount(userID);
		System.out.println("Current Transaction="+current);
		current=current+1;
		System.out.println("New Transaction count="+current);
		Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String sql="update transaction set trans='"+current+"' where uid='"+userID+"'";
		System.out.println(sql);
		stmt.executeUpdate(sql);	
		
	}
	public static int getcurrentCount(String userID) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet res=null;
		Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String sql="select * from transaction where uid='"+userID+"'";
		res=stmt.executeQuery(sql);
		System.out.println(sql);
		res.next();
		int count=Integer.parseInt(res.getString("trans"));
		return count;
		
	}
	private static int getPreviousHash(String userID, int blocknumber) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File f = new File("M:\\Ration\\" + userID+"\\t_"+blocknumber+".ser");
		FileInputStream fin = new FileInputStream(f);
		ObjectInputStream in = new ObjectInputStream(fin);
		Transaction pp = (Transaction) in.readObject();
		return pp.getHash();
		
	}
	private static void serialize(Transaction t, int blocknumber, String userID) throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		File f = new File("M:\\Ration\\" + userID+"\\t_"+blocknumber+".ser");
		t.setTid(DataEncryption.encryptionPRocess(t.getTid(), Integer.parseInt(userID)));
		t.setBevid(DataEncryption.encryptionPRocess(t.getBevid(), Integer.parseInt(userID)));
		t.setDate(DataEncryption.encryptionPRocess(t.getDate(), Integer.parseInt(userID)));
		String products[]=t.getProducts();
		for (int i = 0; i < products.length; i++) {
			products[i]=DataEncryption.encryptionPRocess(products[i], Integer.parseInt(userID));
		}
		t.setProducts(products);
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutput out = new ObjectOutputStream(fout);
		out.writeObject(t);
		
	}

}
