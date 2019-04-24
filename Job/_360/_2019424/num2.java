package _360._2019424;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class num2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ball = in.nextInt();
            if (map.get(ball) == null){
                map.put(ball,1);
                m++;
            }
            else {
                map.put(ball,map.get(ball) + 1);
            }
        }
        int i = 0;
        int[] numbers = new int[m];
        for (Integer value:map.values()) {
            numbers[i++] = value;
        }
        int gys = findgys(numbers[0],numbers[1]);
        i = 2;
        if (gys < 2){
            System.out.println(0);
        }
        else{
            while (i < m){
                gys = findgys(gys,numbers[i]);
                if (gys < 2){
                    System.out.println(0);
                    break;
                }
                i++;
            }
            if (gys > 1){
                int ans = 0;
                for (int j = 0; j < m; j++) {
                    ans += numbers[j] / gys;
                }
                System.out.println(ans);
            }
        }
        

    }

    private static int findgys(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }


}
