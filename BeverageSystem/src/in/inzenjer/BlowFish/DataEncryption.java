package in.inzenjer.BlowFish;

import javax.swing.*;



import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DataEncryption {
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

	public DataEncryption() {
		try {

		} catch (Exception e) {
			System.out.println("hoii catch==" + e);
		}

	}

	public static String encryptionPRocess(String data, int skey) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Current Data===" + data);
		inputMessage = data;
		generateSymmetricKey(skey);
		ibyte = inputMessage.getBytes();
		// ebyte = encrypt(raw, ibyte);
		String encryptedData = encrypt(raw, ibyte);
		// = new String(ebyte);
		/*if (i != 100) {
			TOTAL_ENRYPTED_DATA[i] = encryptedData;
		}*/
		System.out.println("encrypted data" + "=" + encryptedData);
		return encryptedData;

	}

	/*
	 * public static String decryptdata(String data, int i) throws Exception {
	 * // System.out.println("key===" + SECRET_KEYS[i]); try{ String decryptedM
	 * =ValidateData.Binarydata(data);
	 * System.out.println("FInallll="+decryptedMessage);
	 * decryptedMessage=decryptedM; generateSymmetricKey(i); // byte total[] =
	 * ENC[i].getBytes(); byte[] dbyte = decrypt(raw, data.getBytes());
	 * System.out.println(
	 * "dataaaa======================================================\n");
	 * System.out.println(data);
	 * 
	 * // System.out.println("secret Key " + i + "=" + SECRET_KEYS[i]); //
	 * System.out.println("encrypted message from DB " + i + "==" + ENC[i]);
	 * System.out.println("Decrypted message " + i + "==" + decryptedMessage);
	 * }catch(Exception e){ e.printStackTrace(); } return decryptedMessage;
	 * 
	 * }
	 */
	public static String decryptdata(String data, int skey) throws Exception {
		generateSymmetricKey(skey);
		byte total[] = data.getBytes();
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
		byte[] dbyte = decrypt(raw, decordedValue);
		String decryptedMessage = new String(dbyte);
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
			// System.out.println("inside catch" + e);
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

	private static String encrypt(byte[] raw, byte[] clear) throws Exception {

		SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		String encryptedValue = new BASE64Encoder().encode(encrypted);
		// return encrypted;
		return encryptedValue;
	}

	private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {

		SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}

	public static void main(String args[]) throws IOException, Exception {
		DataEncryption bf = new DataEncryption();
		System.out.println("enter any elements for decrypt");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = encryptionPRocess(br.readLine(),1);
		System.out.println("encrypted data=" + data);
		String dec = decryptdata(data, 1);
		System.out.println("after=" + dec);
	}
}