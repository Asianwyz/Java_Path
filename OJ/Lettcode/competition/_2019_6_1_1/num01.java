package Lettcode.competition._2019_6_1_1;

public class num01 {
    public static void main(String[] args) {
        int[] A = {-10,-5,0,3,7};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i)
                return i;
        }
        return -1;
    }
}
