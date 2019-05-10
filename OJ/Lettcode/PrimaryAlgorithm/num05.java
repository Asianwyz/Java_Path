package Lettcode.PrimaryAlgorithms.Array;

import java.util.Arrays;

/**
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class num05 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int flag = solution(nums);
        System.out.println(flag);
    }

    private static int solution(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length ; i++) {
            if (ans == nums[i]){
                count++;
            }
            else if (count == 2){
                ans = nums[i];
                count = 1;
            }
            else break;
        }
        return ans;
    }
}
