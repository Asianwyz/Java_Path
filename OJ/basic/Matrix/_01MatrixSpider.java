package basic.Matrix;

/**
 * 转圈打印矩阵
 * 【 题目】 给定一个整型矩阵matrix， 请按照转圈的方式打印它。
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 打印结果为： 1， 2， 3， 4， 8， 12， 16， 15， 14， 13， 9，
 * 5， 6， 7， 11， 10
 * 【 要求】 额外空间复杂度为O(1)。
 */

public class _01MatrixSpider {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }

    private static void spiralOrderPrint(int[][] matrix) {
        int row1 = 0, cow1 = 0;
        int row2 = matrix.length - 1, cow2 = matrix[0].length - 1;
        while (row1 <= row2 && cow1 <= cow2){
            print(matrix,row1++,cow1++,row2--,cow2--);
        }

    }

    private static void print(int[][] matrix, int row1, int cow1, int row2, int cow2) {
        int x = row1;
        int y = cow1;
        if (row1 == row2){
            for (int i = cow1; i < cow2 ; i++) {
                System.out.print(matrix[row1][i] + " ");
            }
        }
        else if (cow1 == cow2){
            for (int i = row1; i < row2 ; i++) {
                System.out.print(matrix[i][cow1] + " ");
            }
        }
        else{
            while (cow1 < cow2){
                System.out.print(matrix[row1][cow1++] + " ");
            }
            while (row1 < row2){
                System.out.print(matrix[row1++][cow2] + " ");
            }
            while (cow1 > y){
                System.out.print(matrix[row1][cow1--] + " ");
            }
            while (row1 > x){
                System.out.print(matrix[row1--][cow1] + " ");
            }
        }
    }
}
