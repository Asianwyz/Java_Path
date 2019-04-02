package job.wangyi;

import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[][] b = new int[n][n];
        int ans = 0;
        int gcd = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i-1; j > -1 ; j--) {
                gcd = getGcd(a[i],a[j]);
                if (gcd == 1){
                    b[i][0]++;
                    b[i][b[i][0]] = j;
                    for (int k = 1; k <= b[j][0]; k++) {
                        gcd = getGcd(a[i],a[b[j][k]]);
                        if (gcd == 1){
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static int getGcd(int a, int b) {
        int r;
        while (b > 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }


}
