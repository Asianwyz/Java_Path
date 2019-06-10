package Lettcode.MiddleAlgorithms.ArrayAndString;

/**
 * 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */

import java.util.Arrays;

public class num01 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
        {3,4,5,2},
            {1,3,1,5}
        };
        matrix = solution(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static int[][] solution(int[][] matrix) {
        int lenrow = matrix.length;
        int lencol = matrix[0].length;
        boolean[] row = new boolean[lenrow];
        boolean[] col = new boolean[lencol];
        for (int i = 0; i < lenrow; i++) {
            for (int j = 0; j < lencol; j++) {
                if (matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < lenrow; i++) {
            if (row[i]){
                for (int j = 0; j < lencol; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < lencol; i++) {
            if (col[i]){
                for (int j = 0; j < lenrow; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;
    }
}
