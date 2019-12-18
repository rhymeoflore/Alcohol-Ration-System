package in.inzenjer.DiffieHellman;

import java.util.ArrayList;
import java.util.Random;

public class KeyGenerationAlgorithm {

	public static int[] GenerateKeys() {
		// TODO Auto-generated method stub
		int G, P;
		int GP[]=new int[2];
		G = generate();
		P = generate();

		System.out.println("GGGGGGGGGgggg="+G);
		System.out.println("PPPPPPPPPPPPP="+P);
		while(P==G){
			P = generate();
		}
		
		GP[0]=G;
		GP[1]=P;
		for (int i = 0; i < GP.length; i++) {
			System.out.println("final G and P ="+GP[i]);
		}
		
		
		return GP;
	}

	private static int generate() {
		// TODO Auto-generated method stub
		int flag = 0, m;
		int generatedValue;
		ArrayList<Integer> PrimeNUmberSet = new ArrayList<Integer>();

		for (int n = 1; n < 30; n++) {
			flag = 0;
			System.out.println("checking " + n);
			m = n / 2;
			for (int i = 2; i <= m; i++) {
				if (n % i == 0) {

					flag = 1;

				}
			}

			if (flag == 0) {
				System.out.println("Number is prime=" + n);
				PrimeNUmberSet.add(n);
			}
		}
		int position = randomNUmberGeneration(PrimeNUmberSet.size());
		return PrimeNUmberSet.get(position);
	}

	private static int randomNUmberGeneration(int primeNumberSize) {
		// TODO Auto-generated method stub

		Random r = new Random();
		int Low = 0;
		int High = primeNumberSize;
		int key = r.nextInt(High - Low) + Low;
		return key;

	}

}
