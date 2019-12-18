import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import in.inzenjer.BlockChain.Transaction;

public class AAA {

	public static void main(String[] args) {
		File folder = new File("M:\\Ration\\");
		File subfolders[] = folder.listFiles();
		for (File f : subfolders) {
			System.out.println(f.getName());
			File[] files=f.listFiles();
			for(File eachfile:files){
				if(!f.getName().equals("head.ser")){
				eachfile.delete();
				}
			}
			}
		}
	}

