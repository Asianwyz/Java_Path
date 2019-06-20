package Lettcode.let;

import java.util.ArrayList;
import java.util.List;

public class num52 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int[] record = new int[n];
        return find(0,record,n);
    }

    private static int find(int i, int[] record, int n) {
        if (i == n){
            return 1;
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record,i,j)){
                record[i] = j;
                ans += find(i + 1,record,n);
            }
        }
        return ans;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }
}
