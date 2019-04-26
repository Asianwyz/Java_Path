package basic.sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1] ; j--) {
                swap(arr,j,j+1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int j, int i) {
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }
}
