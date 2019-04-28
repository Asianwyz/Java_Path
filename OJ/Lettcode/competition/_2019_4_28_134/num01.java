package Lettcode.competition._2019_4_28_134;

public class num01 {
    public static void main(String[] args) {
        int a = 3;
        int b = 21;
        int c = 27;
        int[] ans = solution(a,b,c);
        System.out.println(ans[0] + "   " + ans[1]);
    }

    private static int[] solution(int a, int b, int c) {
        int x = minNumber(a,minNumber(b,c));
        int z = maxNumber(a,maxNumber(b,c));
        int y = a + b + c - x - z;
        int d1 = y - x - 1;
        int d2 = z - y - 1;
        int max = d1 + d2;
        int min = 0;
        if (d1 == 0 && d2 == 0){
            return new int[] {0,0};
        }
        else if (d1 == 0 || d2 == 0 || d1 == 1 || d2 == 1){
            return new int[] {1,max};
        }
        while (true){
            if (d1 < d2){
                z = y;
            }
            else{
                x = y;
            }
            ++min;
            y = (x + z) / 2;
            d1 = y - x - 1;
            d2 = z - y - 1;
            if (d1 == 0 || d2 == 0 || d1 == 1 || d2 == 1){
                ++min;
                break;
            }
        }
        return new int[] {min, max};
    }

    private static int minNumber(int a, int b) {
        return a < b ? a : b;
    }
    private static int maxNumber(int a, int b) {
        return a > b ? a : b;
    }
}
