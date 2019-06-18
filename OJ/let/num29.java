package Lettcode.let;

public class num29 {
    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = 1;
        int ans = ssolution(dividend,divisor);
        System.out.println(ans);
    }

    private static int ssolution(int dividend, int divisor) {
        int ans = 0;
        if (dividend == Integer.MIN_VALUE){
            ans++;
            dividend -= divisor;
        }
        int k = 1;
        if (dividend < 0){
            k *= -1;
            dividend *= -1;
        }
        if (divisor < 0){
            k *= -1;
            divisor *= -1;
        }
        int count = 1;
        int d = divisor;
        while (dividend > 0){
            if (dividend < divisor){
                break;
            }
            if (dividend < d){
                d = divisor;
                count = 1;
                if (Integer.MAX_VALUE - 1 > ans)
                    return Integer.MAX_VALUE;
                ans++;
                dividend -= d;
            }
            else{
                dividend -= d;
                if (Integer.MAX_VALUE - count > ans)
                    return Integer.MAX_VALUE;
                ans += count;
                d <<= 1;
                count <<= 1;
            }
        }
        return ans;
    }

    /**
     * 超时
     * @param dividend
     * @param divisor
     * @return
     */
    private static int solution(int dividend, int divisor) {
        int k = 1;
        if (dividend < 0){
            k *= -1;
            dividend *= -1;
        }
        if (divisor < 0){
            k *= -1;
            divisor *= -1;
        }
        int ans = 0;
        while (dividend > 0){
            if (dividend < divisor)
                break;
            ans++;
            dividend -= divisor;
        }
        return ans * k;
    }
}
