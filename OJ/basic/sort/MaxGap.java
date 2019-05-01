package basic.sort;

/**
 * 给定一个数组， 求如果排序之后， 相邻两数的最大差值， 要求时
 * 间复杂度O(N)， 且要求不能用非基于比较的排序。
 */

import java.util.Scanner;

public class MaxGap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        if (min == max){
            System.out.println(0);
            return;
        }
        boolean[] hasNum = new boolean[n + 1];
        int[] maxs = new int[n + 1];
        int[] mins = new int[n + 1];
        int bid = 0;
        for (int i = 0; i < n; i++) {
            bid = bucket(arr[i],n,min,max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= n; i++) {
            if (hasNum[i]){
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        System.out.println(res);
    }

    private static int bucket(long num , long n, long min, long max) {
        return (int) ((num - min) * n / (max - min));
    }
}
