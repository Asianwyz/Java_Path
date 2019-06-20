package Lettcode.let;

import java.util.ArrayList;
import java.util.List;

public class num54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},

        };
        List<Integer> list = solution(matrix);
        System.out.println(list);
    }

    private static List<Integer> solution(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length,maxn = n;
        int m = matrix[0].length, maxm = m;
        int x = 0, y = 0;
        int minx = 0, miny = 0;
        int flag = 1;
        while (list.size() < n * m){
            if (flag == 1){
                while (y < maxm){
                    list.add(matrix[x][y++]);
                }
                flag = 2;
                y--;
                x++;
                maxm--;
            }
            else if (flag == 2){
                while (x < maxn){
                    list.add(matrix[x++][y]);
                }
                flag = 3;
                x--;
                y--;
                maxn--;
            }
            else if (flag == 3){
                while (y >= miny){
                    list.add(matrix[x][y--]);
                }
                y++;
                x--;
                flag = 4;
                miny++;
            }
            else if (flag == 4){
                while (x > minx){
                    list.add(matrix[x--][y]);
                }
                flag = 1;
                y++;
                x++;
                minx++;
            }
        }
        return list;
    }
}
