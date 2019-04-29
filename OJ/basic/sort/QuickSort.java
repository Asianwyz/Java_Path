package basic.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快排
 * 01 stable sort能实现排序的稳定性
 */

public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        qsort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void qsort(int[] arr, int l, int r) {
        if (l < r){
            swap(arr,l + (int)(Math.random() * (r - l + 1)), r);
            int[] p = partition(arr,l,r);
            qsort(arr,l,p[0] - 1);
            qsort(arr,p[1] + 1,r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more){
            if (arr[l] > arr[r]){
                swap(arr,l,--more);
            }
            else if (arr[l] < arr[r]){
                swap(arr,++less,l++);
            }
            else{
                ++l;
            }
        }
        swap(arr,more,r);
        return new int[] {less + 1, more};
    }

    private static void swap(int[] arr, int j, int i) {
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }
}
