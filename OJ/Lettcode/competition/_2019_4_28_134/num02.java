package Lettcode.competition._2019_4_28_134;

import java.util.Arrays;

public class num02 {
    public static void main(String[] args) {
        int[][] grid = {{1,2,2},{2,3,2}};
        int x = 0;
        int y = 1;
        int color = 3;
        int[][] ans = solution(grid,x,y,color);
    }

    private static int[][] solution(int[][] grid, int x, int y, int color) {
        int n = grid.length;
        int m = grid[0].length;
//        int[][] ans = new int[n][m];
        boolean[][] flag = new boolean[n][m];
//        int[][] d = new int[n * m][2];
//        d[0][0] = x;
//        d[0][1] = y;
//        flag[x][y] = true;
        int init = grid[x][y];
        draw(grid,x,y,n,m,init,flag);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (flag[i][j]){
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1){
                        grid[i][j] = color;
                    }
                    if (i - 1 >= 0 && flag[i - 1][j] && j -1 >= 0 && flag[i][j-1] && i + 1 < n && flag[i + 1][j] &&
                        j + 1 < m && flag[i][j + 1]){
                        continue;
                    }
                    grid[i][j] = color;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        return grid;
    }

    private static void draw(int[][] grid, int x, int y, int n, int m, int init,boolean[][] flag) {
        flag[x][y] = true;
        if (x + 1 < n && grid[x + 1][y] == init && !flag[x + 1][y])
            draw(grid,x + 1,y,n,m,init,flag);
        if (y + 1 < m && grid[x][y + 1] == init && !flag[x][y + 1])
            draw(grid,x,y + 1,n,m,init,flag);
        if (x - 1 >= 0 && grid[x - 1][y] == init && !flag[x - 1][y])
            draw(grid,x - 1,y,n,m,init,flag);
        if (y - 1 >= 0 && grid[x][y - 1] == init && !flag[x][y - 1])
            draw(grid,x,y - 1,n,m,init,flag);
    }
}
