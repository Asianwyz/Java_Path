import java.util.Scanner;

public class Fib {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if (n < 2) {
			System.out.println(1);
		}
		else {
			long a = 1, b = 1, c;
			for (int i = 2; i <= n; ++i) {
				c = a + b;
				a = b;
				b = c;
			}
			System.out.println(b);
		}
		input.close();
		
	}
}

//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		
//		Scanner input = new Scanner(System.in);
//		int n = input.nextInt();
//		Long[] fib = new Long[n+1];
//		fib[0] = (long) 1;
//		fib[1] = (long) 1;
//		for (int i = 2; i <= n; ++i) {
//			fib[i] = fib[i-1] + fib[i-2];
//		}
//		System.out.println(fib[n]);
//		
//	}
//}
