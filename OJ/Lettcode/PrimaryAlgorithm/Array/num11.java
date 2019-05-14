package Lettcode.PrimaryAlgorithms.Array;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */

/**
 * 解题思路：
 *      按圈依次旋转
 */

import java.util.Arrays;

public class num11 {
    public static void main(String[] args) {
        int[][] matrix = {
            {5, 1, 9,11},
            {2, 4, 8,10},
            {13, 3, 6, 7},
            {15,14,12,1}
        };
        solution(matrix);
        printM(matrix);
    }

    private static void solution(int[][] matrix) {
        int x = 0;
        int y = matrix.length - 1;
        while (x < y){
            swap(x,y,matrix);
            x++;
            y--;
        }
    }

    private static void swap(int x, int y, int[][] matrix) {
        int[] tmp = matrix[x].clone();
        for (int i = 0; i < y - x ; i++) {
            matrix[x][x + i] = matrix[y - i][x];
        }
        for (int i = 1; i <= y - x; i++) {
            matrix[x+i][x] = matrix[y][x + i];
        }
        for (int i = 1; i <= y - x; i++) {
            matrix[y][x + i] = matrix[y - i][y];
        }
        for (int i = 0; i < y - x; i++) {
            matrix[x + i][y] = tmp[x + i];
        }
    }

    private static void printM(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("--------------------------");
    }
}
