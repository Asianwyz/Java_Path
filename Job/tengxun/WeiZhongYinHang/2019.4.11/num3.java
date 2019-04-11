package TengXun.WeiZhongYinHang._2019_4_11;

import java.util.Scanner;

public class num3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            System.out.println(tgz(n,0));
        }
    }

    private static int tgz(int n, int ans){
        if (n == 1)
            return ans;
        if (n % 2 == 0){
            return tgz(n / 2, ans+1);
        }
        else {
            return tgz(n * 3 + 1, ans + 1);
        }
    }
}
