package Lettcode.let;

public class num11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution1(height));
    }

    private static int solution1(int[] height) {
        int len = height.length;
        int max = Math.min(height[0],height[len - 1]) * (len - 1);
        int l = 0, r = len - 1;
        while (l < r){
            int x = Math.min(height[l],height[r]) * (r - l);
            max = max < x ? x : max;
            if (height[l] < height[r]){
                l++;
            }
            else {
                r--;
            }
        }
        return max;
    }

    /**
     * 暴力+优化
     * @param height
     * @return
     */
    private static int solution(int[] height) {
        int len = height.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            if ((len - i) * height[i] < max)
                continue;
            for (int j = i + 1; j < len ; j++) {
                int x = Math.min(height[i],height[j]) * (j - i);
                max = max < x ? x : max;
            }
        }
        return max;
    }
}
