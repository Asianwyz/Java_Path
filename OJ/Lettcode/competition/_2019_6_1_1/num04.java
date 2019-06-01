package Lettcode.competition._2019_6_1_1;

public class num04 {
    public static void main(String[] args) {
        int d = 0;
        int low = 1;
        int high = 200000000;
        System.out.println(solution(d,low,high));
    }

    private static int solution(int d, int low, int high) {
        int times = 0;
        for (int i = low; i <= high ; i++) {
            times += count(d,i);
        }
        return times;
    }

    private static int count(int d, int i) {
        int x = 0;
        while (i > 0){
            int y = i % 10;
            if (y == d)
                ++x;
            i /= 10;
        }
        return x;
    }
}
