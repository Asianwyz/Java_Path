package Lettcode.let;

public class num42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int v = solution(height);
    }

    private static int solution(int[] height) {
        int len = height.length;
        if (len < 3)
            return 0;
        int begin = 0;
        while (begin < len - 1 && height[begin] < height[begin + 1])
            begin++;
        int end = len - 1;
        while (end > 0 && height[end] < height[end - 1])
            end--;
        if (end - begin < 2)
            return 0;
        for (int i = 0; i < end; i++) {
            
        }
        return 0;
    }
}
