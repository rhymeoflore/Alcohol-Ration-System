package in.inzenjer.Random;

import java.util.Random;

public class RandomNumberGeneration {

	public static int generateRandomNUmber() {
		Random r = new Random();
		int Low = 1001;
		int High = 9999;
		int key = r.nextInt(High - Low) + Low;
		return key;

	}

	public static int generateRandomNUmberLImit(int l, int h) {
		Random r = new Random();
		int Low = l;
		int High = h;
		//System.out.println("HIGH="+High);
		//System.out.println("LOW="+Low);
		int key = r.nextInt(High - Low) + Low;
		return key;

	}
	
}
