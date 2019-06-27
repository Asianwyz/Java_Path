package Lettcode.let;

public class num42 {
    public static void main(String[] args) {
//        int[] height = {2,0,2};
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {5,4,1,2};
        int v = solution(height);
        System.out.println(v);
    }

    private static int solution(int[] height) {
        int len = height.length;
        if (len < 3)
            return 0;
        int ans = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i > -1 ; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
            ans += Math.min(right[i],left[i]) - height[i];
        }
        return ans;
    }
}
