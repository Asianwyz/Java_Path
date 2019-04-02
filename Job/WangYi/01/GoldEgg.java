package job.wangyi;

import java.util.Scanner;

public class GoldEgg {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[][] b = new int[n][2];
        int[] flag = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i][0] = a[i];
            b[i][1] = i;
            flag[i] = 0;
        }
        int ans = 0, count = n;
        if (a[0] == 1 && n > 1){
            ans += a[1];
            flag[0] = 1;
            left = 1;
            count--;
        }
        if (a[n-1] == 1 && n > 1){
            ans += a[n-2];
            flag[n-1] = 1;
            right = n - 2;
            count--;
        }
        slowsort(b,n);

        for (int i = 0; i < n ; i++) {
            int index = b[i][1];
            if (flag[index] == 1)
                continue;
            if (count <= 2)
                continue;
            if (index == left || index == right)
                continue;
            int leftIndex = findLeft(left,index,flag);
            int rightIndex = findRightt(index,flag,right);
            int add = b[i][0];
            if (leftIndex >= left)
                add *= a[leftIndex];
            if (rightIndex <= right)
                add *= a[rightIndex];
            flag[index] = 1;
            ans += add;
        }
        int max = -1, min = 101;
        for (int i = 0; i < n; i++) {
            if (flag[i] == 0){
                if (max < a[i])
                    max = a[i];
                if (min > a[i])
                    min = a[i];
            }
        }
        if (count > 1){
            ans += max + max * min;
        }
        else {
            ans += max;
        }

        System.out.println(ans);
        String s = "asia,";
        String ss = s.substring(4,5) + s.substring(0,4);
        System.out.println(ss);

    }

    private static int findLeft(int left, int index, int[] flag) {
        int x = index - 1;
        while (x >= left && flag[x] == 1){
            x--;
        }
        return x;
    }
    private static int findRightt(int index, int[] flag, int right) {
        int x = index + 1;
        while (x <= right && flag[x] == 1){
            x++;
        }
        return x;
    }


    private static void slowsort(int[][] b, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j > -1 ; j--) {
                if (b[i][0] < b[j][0]){
                    int x = b[i][0];
                    b[i][0] = b[j][0];
                    b[j][0] = x;
                    int y = b[i][1];
                    b[i][1] = b[j][1];
                    b[j][1] = y;
                }
            }
        }
    }
}
