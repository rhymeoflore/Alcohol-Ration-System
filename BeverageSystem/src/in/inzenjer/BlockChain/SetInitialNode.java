package in.inzenjer.BlockChain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import in.inzenjer.BlowFish.Blowfish;
import in.inzenjer.BlowFish.DataEncryption;
import in.inzenjer.DBConnection.DBConnection;

public class SetInitialNode {
	
	public static void setHeadNode(int ret,String bev,String fn,String ln,String ag,String gen,String addr,String ph) throws Exception{
		String encret=DataEncryption.encryptionPRocess(String.valueOf(ret), ret);
		String encbev=DataEncryption.encryptionPRocess(String.valueOf(bev), ret);
		String encfn=DataEncryption.encryptionPRocess(String.valueOf(fn), ret);
		String encln=DataEncryption.encryptionPRocess(String.valueOf(ln), ret);
		String encag=DataEncryption.encryptionPRocess(String.valueOf(ag), ret);
		String encgen=DataEncryption.encryptionPRocess(String.valueOf(gen), ret);
		String encaddr=DataEncryption.encryptionPRocess(String.valueOf(addr), ret);
		String encph=DataEncryption.encryptionPRocess(String.valueOf(ph), ret);
		
		User u=new User();
		u.setUid(encret);
		u.setBevID(encbev);
		u.setFirstname(encfn);
		u.setLastname(encln);
		u.setAge(encag);
		u.setGender(encgen);
		u.setAddress(encaddr);
		u.setPhone(encph);
		SerializeBlockChain.createDirectory(String.valueOf(ret));
		serializeHeadNode(ret,u);
		updateTransactions(ret);
	}

	private static void updateTransactions(int ret) throws SQLException {
		// TODO Auto-generated method stub
		int tr=0;
		Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String sql="insert into transaction (uid,trans) values('"+ret+"','"+tr+"')";
		stmt.executeUpdate(sql);
	}

	private static void serializeHeadNode(int ret, User u) throws IOException {
		// TODO Auto-generated method stub
		File f;
		f = new File("M:\\Ration\\"+ret+"\\head.ser");
		if (!f.exists()) {
			f.createNewFile();
		}
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutput out = new ObjectOutputStream(fout);
		out.writeObject(u);
		
	}

}
