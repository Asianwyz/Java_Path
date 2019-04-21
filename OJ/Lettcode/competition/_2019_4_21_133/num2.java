package Lettcode.competition._2019_4_21_133;

import static java.lang.Math.abs;

public class num2 {
    public static void main(String[] args) {
        int r = 100;
        int c = 100;
        int x = 1;
        int y = 2;
        int[][] ans = solution(r,c,x,y);
    }

    private static int[][] solution(int R, int C, int r0, int c0) {
        int t = 0;
        int[][] f = new int[R * C][3];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dis = abs(i - r0) + abs(j - c0);
                f[t][0] = dis;
                f[t][1] = i;
                f[t][2] = j;
                t++;
            }

        }
        for (int i = 0; i < t - 1; i++) {
            for (int j = i + 1; j < t ; j++) {
                if (f[i][0] > f[j][0]){
                    for (int k = 0; k < 3; k++) {
                        swap(f,i,j,k);
                    }
                }
            }
        }
        int[][] ans = new int[t][2];
        for (int i = 0; i < t ; i++) {
            ans[i][0] = f[i][1];
            ans[i][1] = f[i][2];
//            System.out.println(f[i][1] + " " + f[i][2]);
        }
        return ans;

    }

    private static void swap(int[][] f, int i, int j, int k) {
        int t = f[i][k];
        f[i][k] = f[j][k];
        f[j][k] = t;
    }
}
