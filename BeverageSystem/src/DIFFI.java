
public class DIFFI {

	public static void main(String[] args) {
		
		int g=11,p=23;
		int aliceSKey=12,BobSkey=8;
		
		int A=(g^aliceSKey)%p;
		int B=(g^BobSkey)%p;
		
		
		System.out.println("final SKEY for alice="+A);
		System.out.println("final SKEY for Bob="+B);
		
		int FInalALice=(B^aliceSKey)%p;
		int FInalBob=(A^BobSkey)%p;
		System.out.println("Alice SKEY=="+FInalALice);
		System.out.println("BOB SKEY=="+FInalBob);
	}
}
