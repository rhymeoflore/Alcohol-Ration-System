package in.inzenjer.BlockChain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import in.inzenjer.BlowFish.DataEncryption;

public class GetBlockChain {

	public static ArrayList<Transaction> readBlockChain(String userID) throws NumberFormatException, Exception {
		File folder = new File("M:\\Ration\\" + userID);
		File files[] = folder.listFiles();
		ArrayList<Transaction> blocklist = new ArrayList<Transaction>();
		for (File f : files) {
			if (!f.getName().equals("head.ser")) {
				FileInputStream fin = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(fin);
				Transaction t = (Transaction) in.readObject();
				t.setTid(DataEncryption.decryptdata(t.getTid(), Integer.parseInt(userID)));
				t.setDate(DataEncryption.decryptdata(t.getDate(), Integer.parseInt(userID)));
				t.setBevid(DataEncryption.decryptdata(t.getBevid(), Integer.parseInt(userID)));
				String products[] = t.getProducts();
				for (int i = 0; i < products.length; i++) {
					products[i] = DataEncryption.decryptdata(products[i], Integer.parseInt(userID));
				}
				blocklist.add(t);

			}
		}
		return blocklist;
	}
}
