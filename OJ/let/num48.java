package Lettcode.let;

public class num48 {
        public void rotate(int[][] matrix) {
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

}
