import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.DBConnection.DBConnection;

public class Test {

	public static void main(String[] args) throws Exception {
		String userID="1";
		String blocknumber="0";
		//File f = new File("E:\\Ration\\" + userID+"\\t_"+blocknumber);
		File f = new File("M:\\Ration\\1\\t_1.ser");
		FileInputStream fin = new FileInputStream(f);
		ObjectInputStream in = new ObjectInputStream(fin);
		Transaction pp = (Transaction) in.readObject();
		System.out.println(DataEncryption.decryptdata(pp.getDate(), 1));
		System.out.println(DataEncryption.decryptdata(pp.getTid(), 1));
		System.out.println(DataEncryption.decryptdata(pp.getBevid(), 1));
		
		
	}
}
