import java.util.Scanner;

public class Intersection {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
		
		int n = in.nextInt();		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}		
		int m = in.nextInt();
		int same = 0;		
		for (int i = 0; i < m; ++i) {
			int k = in.nextInt();
			for (int j = 0; j < n; ++j) {
				if (a[j] == k) {
					++same;
					break;
				}
			}
		}
		
		if (same == 0) {
			System.out.println("None");
		}
		else {
			System.out.println(same);
		}
		
	}
}
