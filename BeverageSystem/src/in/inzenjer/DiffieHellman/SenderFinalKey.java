package in.inzenjer.DiffieHellman;

public class SenderFinalKey {

	public static int Final(int receiverResult, int senderKey, String pValue) {

		int S;
		S = (receiverResult ^ senderKey) % Integer.parseInt(pValue);
		return S;

	}
}
