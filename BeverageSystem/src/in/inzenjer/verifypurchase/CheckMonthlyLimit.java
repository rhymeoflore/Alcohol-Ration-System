package in.inzenjer.verifypurchase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.Time.DateDifferentExample;
import in.inzenjer.Time.Timeee;

public class CheckMonthlyLimit {

	public static int checkLimit(String userID) throws NumberFormatException, Exception {
		int flag = 0;
		File folder = new File("M:\\Ration\\" + userID);
		File files[] = folder.listFiles();
		// ArrayList<Transaction> blocklist=new ArrayList<Transaction>();
		String startDate = null;
		int totalqty = 0;
		for (File f : files) {
			System.out.println(f.getName());
			if (!f.getName().equals("head.ser")) {
				System.out.println("Each Transactionnnnnnnnnnnnn");
				FileInputStream fin = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(fin);
				Transaction t = (Transaction) in.readObject();
				String prod[] = t.getProducts();
				for (int i = 0; i < prod.length; i++) {
					prod[i] = DataEncryption.decryptdata(prod[i], Integer.parseInt(userID));
				}
				if (f.getName().equals("t_1.ser")) {
					System.out.println("FIRST NODE");
					startDate = DataEncryption.decryptdata(t.getDate(), Integer.parseInt(userID));
				}
				for (String p : prod) {
					System.out.println("Each Product\n" + p);
					// String rs=p.substring(p.lastIndexOf("/RS.")+1);
					String qty = p.substring(p.lastIndexOf("ML") - 3, p.lastIndexOf("ML"));
					// System.out.println(rs);
					System.out.println("quantity=" + qty);

					if (!qty.equals("NAN")) {
						totalqty = totalqty + Integer.parseInt(qty);
					}

				}

			}
		}
		System.out.println("startdate=" + startDate);
		System.out.println("TOTAL CONSUMED =" + totalqty);

		System.out.println("Start purchase date=" + startDate);
		if (startDate != null) {
			System.out.println("start date !=null");
			long minutesDiff = DateDifferentExample.checkDateDifference(startDate, Timeee.getDDMMYYYY());
			System.out.println("minutes difffffff="+minutesDiff);
			if (totalqty > (750 * 3)) {
				System.out.println("\nlimit exceeded");
				flag = 1;
			} else {
				System.out.println("\nLImit Not Exceeded you can purchase");
				flag = 0;
			}
		}

		return flag;

	}

	public static void main(String[] args) throws NumberFormatException, Exception {
		checkLimit("2");
	}
}
