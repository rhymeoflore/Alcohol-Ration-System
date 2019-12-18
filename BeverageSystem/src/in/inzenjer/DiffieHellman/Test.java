package in.inzenjer.DiffieHellman;

public class Test {

	public static void main(String[] args) {
		int i, m = 0, flag = 0;
		// int n=17;//it is the number to be checked
		for (int n = 1; n < 100; n++) {
			flag=0;
			System.out.println("checking "+n);
			m = n / 2;
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					//System.out.println("Number is not prime="+n+"%"+i);
					flag = 1;
					
				}
			}

			if (flag == 0) {
				System.out.println("Number is prime="+n);
			}
		}
	}
}
