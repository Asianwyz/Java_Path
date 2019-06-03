package Lettcode.let;

import java.util.Arrays;

public class num16 {
    public static void main(String[] args) {
        int target = -1;
        int[] nums = {1,1,-1,-1,3};
        int threesum = solution(nums,target);
        System.out.println(threesum);
    }

    private static int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int i = 0;
        int len = nums.length;
        while (i < len - 2){
            int j = i + 1;
            int k = len - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                ans = Math.abs(sum - target) < Math.abs(ans - target) ? sum : ans;
                if (sum > target){
                    --k;
                }
                else{
                    ++j;
                }
            }
            ++i;
        }
        return ans;
    }
}
