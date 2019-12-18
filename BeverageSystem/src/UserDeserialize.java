import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import in.inzenjer.BlockChain.Transaction;
import in.inzenjer.BlockChain.User;
import in.inzenjer.BlowFish.Blowfish;
import in.inzenjer.BlowFish.DataEncryption;

public class UserDeserialize {
	public static void main(String[] args) throws Exception {
		File f = new File("M:\\Ration\\2\\head.ser");
		FileInputStream fin = new FileInputStream(f);
		ObjectInputStream in = new ObjectInputStream(fin);
		User u = (User) in.readObject();
		System.out.println(DataEncryption.decryptdata(u.getUid(), 2));
		System.out.println(DataEncryption.decryptdata(u.getFirstname(), 2));
		System.out.println(DataEncryption.decryptdata(u.getLastname(), 2));
		System.out.println(DataEncryption.decryptdata(u.getAge(), 2));
		System.out.println(DataEncryption.decryptdata(u.getAddress(), 2));
		System.out.println(DataEncryption.decryptdata(u.getBevID(), 2));
		System.out.println(DataEncryption.decryptdata(u.getGender(), 2));
		System.out.println(DataEncryption.decryptdata(u.getPhone(), 2));
	}
}
