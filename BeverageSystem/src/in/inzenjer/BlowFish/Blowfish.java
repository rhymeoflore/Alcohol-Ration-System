package in.inzenjer.BlowFish;

import javax.swing.*;


import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Blowfish {
	static byte[] skey = new byte[1000];
	static String skeyString;
	static byte[] raw;
	static String inputMessage;
	String encryptedData;
	static String decryptedMessage;
	static int KEY = 300;
	static String TOTAL_ENRYPTED_DATA[];

	static byte[] ibyte;
	static byte[] ebyte;
	static String decArray[];
	static String TOTAL_DECRYPTED_MESSAGE = "";
	static String regex = "\\d+";

	public Blowfish() {
		/*try {

			System.out.println("enter any elements for decrypt");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br.readLine();

		} catch (Exception e) {
			System.out.println("hoii catch==" + e);
		}*/

	}

	public static String encryptionPRocess(String data, int skey) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Current Data===" + data);
		inputMessage = data;
		generateSymmetricKey(skey);
		ibyte = inputMessage.getBytes();
		ebyte = encrypt(raw, ibyte);
		String encryptedData = new String(ebyte);
		return encryptedData;
	}

	public static String decryptionProcess(String data, int skey) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("key===" + skey);
		generateSymmetricKey(skey);
		// byte total[] = ENC[i].getBytes();
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
		byte[] dbyte = decrypt(raw, decordedValue);
		String decryptedMessage = new String(dbyte);
		System.out.println("Decrypted message==" + decryptedMessage);
		return decryptedMessage;
	}

	public static String getDecryptedMessage() {

		return TOTAL_DECRYPTED_MESSAGE;
	}

	static void generateSymmetricKey(int k) {
		try {
			Random r = new Random();
			int num = r.nextInt(10000);
			String knum = String.valueOf(k);
			byte[] knumb = knum.getBytes();
			skey = getRawKey(knumb);
			skeyString = new String(skey);

		} catch (Exception e) {
			System.out.println("inside catch" + e);
		}
	}

	private static byte[] getRawKey(byte[] seed) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed);
		kgen.init(128, sr); // 128, 256 and 448 bits may not be available
		SecretKey skey = kgen.generateKey();
		raw = skey.getEncoded();
		return raw;
	}

	private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {

		SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		String encryptedValue = new BASE64Encoder().encode(encrypted);
		return encrypted;
	}

	private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {

		SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}

	public static void main(String args[]) throws Exception {
		Blowfish bf = new Blowfish();
		String dat=encryptionPRocess("1", 1);
		System.out.println("enc data="+dat);
		String decdat=decryptionProcess(dat, 1);
		System.out.println("dec data="+decdat);
		
	}
}