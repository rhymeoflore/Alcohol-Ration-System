package in.inzenjer.sheduledAuditing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import in.inzenjer.BlockChain.BlockChain;
import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlockChain.ValidateBlockChain;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.DBConnection.DBConnection;
import in.inzenjer.Time.SubtractMinutes;
import in.inzenjer.Time.Timeee;
import in.inzenjer.alert.AlertMessages;
import in.inzenjer.verifypurchase.ConfirmOrder;

public class checkingCorruption implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = getAllUsers();
			checkingBlockChain(rs);
		} catch (Exception e) {
			
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void checkingBlockChain(ResultSet rs) throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		while(rs.next()){
			boolean r=validatingBlockChain(rs.getString("uid"));
			
			if(!r){
				System.out.println("BlockChain Validated For "+rs.getString("uid") +"is false");
				checkEachUserChain(rs.getString("uid"));
			}else{
				System.out.println("BlockChain Validated For "+rs.getString("uid") +"is true");
			}
			
			
		}
		
	}
	private boolean validatingBlockChain(String userID) throws SQLException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File folder = new File("M:\\Ration\\" + userID);
		File files[] = folder.listFiles();
		int TCount=ConfirmOrder.getcurrentCount(userID);
		ArrayList<Transaction> blocks=new ArrayList<Transaction>();
		for (File f : files) {
			if(!f.getName().equals("head.ser")){
				FileInputStream fin = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(fin);
				Transaction t = (Transaction) in.readObject();
				blocks.add(t);
				
			}
			
		}
		boolean result=ValidateBlockChain.validate(blocks);
		return result;
		 
	}
	private void checkEachUserChain(String userID) throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		int filescount=0;
		File folder = new File("M:\\Ration\\" + userID);
		File files[] = folder.listFiles();
		int TCount=ConfirmOrder.getcurrentCount(userID);
		int filenumber[]=new int[TCount];
		int startcount=1;
		for (int i = 0; i < filenumber.length; i++) {
			filenumber[i]=startcount;
			startcount=startcount+1;
			
		}
		ArrayList<String> filenames=new ArrayList<String>();
		for (File f : files) {
			if(!f.getName().equals("head.ser")){
				filescount=filescount+1;
				filenames.add(f.getName());	
			}
		}
		if(filescount!=TCount){
			System.out.println("Block != Trans count");
			System.out.println(filescount+"!="+TCount);
			String startDate="";
			Transaction t;
			File f=new File("M:\\Ration\\" + userID+"\\t_1.ser");
			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fin);
			 t = (Transaction) in.readObject();
			 banCUrrentMonth(userID);
			 /*startDate = DataEncryption.decryptdata(t.getDate(), Integer.parseInt(userID));
			 String DATE=SubtractMinutes.minuteToBack(startDate);
			// String DATE=Timeee.getDDMMYYYY();
			 t.setDate(DataEncryption.encryptionPRocess(DATE, Integer.parseInt(userID)));
			 rewriteData(t,userID,1);*/
		}
		AlertMessages.recordAlertMessages(filenames,filenumber,userID);
		
	}
	private void banCUrrentMonth(String userID) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql="update transaction set trans=-1 where uid='"+userID+"'";
		int ret=stmt.executeUpdate(sql);
		
	}
	private void rewriteData(Transaction t,String userID, int blocknumber) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("rewriting date");
		File f = new File("E:\\Ration\\" + userID+"\\t_"+blocknumber+".ser");
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutput out = new ObjectOutputStream(fout);
		out.writeObject(t);
		
	}
	private ResultSet getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from user";
		res = stmt.executeQuery(sql);
		return res;

	}

}
