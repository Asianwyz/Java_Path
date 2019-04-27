package basic.sort;

import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            heapInsert(arr,i);
        }
        while (n > 0){
            System.out.print(arr[0] + ' ');

        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }
}
