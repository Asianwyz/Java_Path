package Lettcode.let;

import java.util.HashSet;
import java.util.Set;

public class num202 {
    public static void main(String[] args) {
        int n = 19;
        boolean isHappy = solution(n);
        System.out.println(isHappy);
    }

    private static boolean solution(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1){
            int m = 0;
            while (n > 0){
                int x = n % 10;
                m += x * x;
                n = n / 10;
            }
            n = m;
            if (set.contains(n)){
                return false;
            }
            else set.add(n);
        }
        return true;
    }
}
