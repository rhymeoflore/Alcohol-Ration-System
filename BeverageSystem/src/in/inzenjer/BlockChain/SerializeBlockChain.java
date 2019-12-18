package in.inzenjer.BlockChain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeBlockChain {

	public static void createDirectory(String ret) {
		File f;
		f = new File("M:\\Ration\\"+ret);
		
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	public static void serializeFulllockChain(int genID,int uid,String gpid,String recv,List<Block> totalblockChain) throws IOException {
		for (int i = 0; i < totalblockChain.size(); i++) {
			File f;
			if(recv!=null){
			 f = new File("M:\\MagicPlus\\"+genID+uid+gpid+recv+"\\bloc" + i + ".ser");
			}else{
				 f = new File("M:\\MagicPlus\\"+genID+gpid+uid+"\\bloc" + i + ".ser");
			}
			if (!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutput out = new ObjectOutputStream(fout);
			out.writeObject(totalblockChain.get(i));
		}
	}

	public static List<Block> deSerializeFulllockChain(int genID, int uid, String gpid, String recv) throws IOException, ClassNotFoundException {

		File folder;
		if(recv!=null){
		folder = new File("M:\\MagicPlus\\"+genID+uid+gpid+recv);
		}else{
			folder = new File("M:\\MagicPlus\\"+genID+gpid+uid);
		}
		
		System.out.println("PPAATTHH="+"M:\\MagicPlus\\"+genID+uid+gpid+recv);
		File files[] = folder.listFiles();
		List<Block> TotaldeserializeblockChain = new ArrayList<>();
		for (File f : files) {

			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fin);
			Block pp = (Block) in.readObject();
			TotaldeserializeblockChain.add(pp);
		}
		return TotaldeserializeblockChain;
	}
}
