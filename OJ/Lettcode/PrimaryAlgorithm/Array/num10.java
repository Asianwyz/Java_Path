package Lettcode.PrimaryAlgorithms.Array;

public class num10 {
    public static void main(String[] args) {
        char[][] board = {
            {'.','.','.','.','5','.','.','1','.'},
            {'.','4','.','3','.','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','1'},
            {'8','.','.','.','.','.','.','2','.'},
            {'.','.','2','.','7','.','.','.','.'},
            {'.','1','5','.','.','.','.','.','.'},
            {'.','.','.','.','.','2','.','.','.'},
            {'.','2','.','9','.','.','.','.','.'},
            {'.','.','4','.','.','.','.','.','.'}
        };
        boolean flag = solution(board);
        System.out.println(flag);
    }

    private static boolean solution(char[][] board) {
        boolean ans = false;
        for (int i = 0; i < 9; i++) {
            ans = check1(board,i,1) && check1(board,i,2);
            if (!ans)
                return ans;
        }
        int[][] f = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        for (int i = 0; i < 9; i++) {
            ans = check2(f[i][0],f[i][1],board);
            if (!ans)
                return ans;
        }
        return ans;
    }

    private static boolean check2(int x, int y, char[][] board) {
        boolean[] flag = new boolean[10];
        for (int i = 0; i < 3; i++) {
            int t1 = x + i;
            for (int j = 0; j < 3; j++) {
                int t2 = y + j;
                if (board[t1][t2] == '.')
                    continue;
                int t = (int)board[t1][t2] - 48;
                if (flag[t]){
                    return false;
                }
                else flag[t] = true;

            }
        }
        return true;
    }

    private static boolean check1(char[][] board, int i, int x) {
        boolean[] flag = new boolean[10];
        if (x == 1){
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int t = (int)board[i][j] - 48;
                if (flag[t]){
                    return false;
                }
                else flag[t] = true;
            }
        }
        else{
            flag = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                int t = (int)board[j][i] - 48;
                if (flag[t]){
                    return false;
                }
                else flag[t] = true;
            }
        }
        return true;
    }
}
