import java.util.Scanner;

public class StringSort {
	public static void main(String[] args) {
		int n;
		String[] s;
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		s = new String[n];
		for (int i = 0; i < n; ++i) {
			s[i] = input.next();
		}
		for (int i = 0; i < n; ++i)
			for (int j = i + 1; j < n; ++j) {
				if (s[i].compareTo(s[j]) > 0) {
					String ss = s[i];
					s[i] = s[j];
					s[j] = ss;
				}
			}
		
		for (int i = 0; i < n; ++i) {
			System.out.println(s[i]);
		}
		
	}
}
