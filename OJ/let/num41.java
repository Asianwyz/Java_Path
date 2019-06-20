package Lettcode.let;

import java.util.Arrays;

public class num41 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int ans = solution(nums);
        System.out.println(ans);
    }

    private static int solution(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (ans == nums[i]){
                ans++;
            }
        }
        return ans;
    }
}
