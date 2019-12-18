package in.inzenjer.DiffieHellman;

public class ReceiverFinalKey {
	
	public static int A;
	public static int b;
	

	public static int Final(int senderResut, int receiverKey, String pValue) {
		int S;
		A=senderResut;
		b=receiverKey;
		S = (senderResut ^ receiverKey) % Integer.parseInt(pValue);
		return S;

	}

}
