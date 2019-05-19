package Lettcode.competition._2019_5_12_136;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入：
 * 5
 * [[4,1],[4,2],[4,3],[2,5],[1,2],[1,5]]
 * 输出：
 * [1,3,5,4,2]
 * 预期：
 * [1,2,1,3,3]
 */
public class num02 {
    public static void main(String[] args) {
        int n = 5;
        int[][] paths = {{4,1},{4,2},{4,3},{2,5},{1,2},{1,5}};
        int[] ans = solution(n,paths);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solution(int N, int[][] paths) {
        int[] ans = new int[N];
        int[][] d = new int[N][4];
        int[] flag = new int[N];
        for (int i = 0; i < paths.length; i++) {
            int x = paths[i][0] - 1;
            int y = paths[i][1] - 1;
            d[x][0]++;
            d[x][d[x][0]] = y;
            d[y][0]++;
            d[y][d[y][0]] = x;
        }
        for (int i = 0; i < N; i++) {
            if (flag[i] != 0){
                continue;
            }
            int flower = 1;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            flag[i] = 1;
            while (!stack.empty()){
                int x = stack.pop();
                ans[x] = flower++;
                for (int j = 1; j <= d[x][0]; j++) {
                    int y = d[x][j];
                    if (flag[y] != 0)
                        continue;
                    stack.push(y);
                    flag[y] = 1;
                }
            }
        }
        return ans;
    }
}
