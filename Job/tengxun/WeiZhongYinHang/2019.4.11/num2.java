package TengXun.WeiZhongYinHang._2019_4_11;

import java.util.Scanner;

public class num2 {
    public static void main(String[] args) {
        int n,k,m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        m = in.nextInt();
        int ans = 0;
        ans = (n / m) * k;
        if (n % m != 0){
            ans += k;
        }
        System.out.println(ans);
    }
}
