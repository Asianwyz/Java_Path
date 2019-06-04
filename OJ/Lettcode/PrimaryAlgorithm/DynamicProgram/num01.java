package Lettcode.PrimaryAlgorithms.DynamicProgram;

public class num01 {
    public static void main(String[] args) {
        int n = 5;
        int ans = solution(n);
        System.out.println(ans);
    }

    private static int solution(int n) {
        if (n == 1)
            return 1;
        if (n == 2){
            return 2;
        }
        int x = 1, y = 2, t = 0;
        int i = 2;
        while (i < n){
            t = x + y;
            x = y;
            y = t;
            ++i;
        }
        return t;
    }
}
