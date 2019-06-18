package Lettcode.let;

public class num122 {
    public int maxProfit(int[] prices) {
        boolean flag = false;
        int n = prices.length;
        int x = 0;
        int buyprice = 0;
        int benefit = 0;
        while (x < n){
            if (x == n - 1){
                if (flag){
                    benefit += prices[x] - buyprice;
                }
                break;
            }
            if (prices[x+1] > prices[x]){
                if (flag) {
                    ++x;
                    continue;
                }
                buyprice = prices[x];
                flag = true;
            }
            else if (flag) {
                benefit += prices[x] - buyprice;
                flag = false;
            }
            ++x;
        }
        return benefit;
    }
}
