package Lettcode.PrimaryAlgorithms.DynamicProgram;

public class num04 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int money = solution(nums);
        System.out.println(money);
    }

    private static int solution(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < len ; i++) {
            int add = 0;
            if (i - 2 >= 0) add = dp[i - 2];
            if (i - 3 >= 0) add = add < dp[i - 3] ? dp[i - 3] : add;
            dp[i] = add + nums[i];
            ans = ans < dp[i] ? dp[i] : ans;
        }
        return ans;
    }
}
