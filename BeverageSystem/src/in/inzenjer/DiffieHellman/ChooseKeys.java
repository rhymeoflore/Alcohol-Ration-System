package in.inzenjer.DiffieHellman;

import in.inzenjer.Random.RandomNumberGeneration;

public class ChooseKeys {

	public static int HIGH, LOW;
	public static int KEYFORPROCESS;

	public static int[] getFinalKeys(String gValue, String pValue) {
		HIGH = 0;
		LOW = 0;
		System.out.println("start");
		getGreatestValue(Integer.parseInt(gValue), Integer.parseInt(pValue));
		System.out.println("greatest and lowest are==");
		System.out.println("value high=" + HIGH);
		System.out.println("value low=" + LOW);
		int senderKey[] = getKeyForSender(Integer.parseInt(gValue), Integer.parseInt(pValue));
		int receiverKey[] = getKeyForReceiver(Integer.parseInt(gValue), Integer.parseInt(pValue));
		int FinalData[] = new int[2];
		FinalData[0] = SenderFinalKey.Final(receiverKey[0], senderKey[1], pValue);
		FinalData[1] = ReceiverFinalKey.Final(senderKey[0], receiverKey[1], pValue);
		// System.out.println("finalData[0]="+FinalData[0]);
		// System.out.println("finalData[1]="+FinalData[1]);
		KEYFORPROCESS = FinalData[1];
		return FinalData;
	}

	private static int[] getKeyForReceiver(int gValue, int pValue) {
		// TODO Auto-generated method stub
		System.out.println("receiver find skey between "+LOW+ "and "+HIGH);
		int SECRETKEY = RandomNumberGeneration.generateRandomNUmberLImit(LOW, HIGH);
		System.out.println(" rec key found="+SECRETKEY);
		while (SECRETKEY < 1 || SECRETKEY > HIGH) {
			System.out.println("whileeeeeeeeeee=" + SECRETKEY);
			SECRETKEY = RandomNumberGeneration.generateRandomNUmberLImit(LOW, HIGH);
		}
		int B = (gValue ^ SECRETKEY) % pValue;
		System.out.println("b="+SECRETKEY);
		System.out.println("B="+B);
		int arr[] = new int[2];
		arr[0] = B;
		arr[1] = SECRETKEY;
		return arr;

	}

	private static void getGreatestValue(int g, int p) {
		// TODO Auto-generated method stub
		System.out.println("G=" + g);
		System.out.println("P=" + p);
		if (g > p) {
			HIGH = g;
			LOW = p;
		} else {
			HIGH = p;
			LOW = g;
		}
		System.out.println();
	}

	private static int[] getKeyForSender(int gValue, int pValue) {
		// TODO Auto-generated method stub
		System.out.println("sender find skey between "+LOW+ "and "+HIGH);
		int SECRETKEY = RandomNumberGeneration.generateRandomNUmberLImit(LOW, HIGH);
		System.out.println(" sender key found="+SECRETKEY);
		while (SECRETKEY < LOW || SECRETKEY > HIGH) {
			System.out.println("whileeeeeeeeesenderrrrrrrr=" + SECRETKEY);
			SECRETKEY = RandomNumberGeneration.generateRandomNUmberLImit(LOW, HIGH);
		}
		int A = (gValue ^ SECRETKEY) % pValue;
		System.out.println("a="+SECRETKEY);
		System.out.println("A="+A);
		int arr[] = new int[2];
		arr[0] = A;
		arr[1] = SECRETKEY;
		return arr;
	}

	public static void main(String[] args) {
		int a[] = getFinalKeys("11", "23");
		
		while(a[0]!=a[1]){
			a=getFinalKeys("11", "23");
		}
		System.out.println("sender key="+a[0]);
		System.out.println("receiver key="+a[1]);
	}
}
