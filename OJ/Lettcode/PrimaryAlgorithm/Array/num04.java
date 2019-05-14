package Lettcode.PrimaryAlgorithms.Array;

import java.util.Arrays;

/**
 *   存在重复
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class num04 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean flag = solution(nums);
        System.out.println(flag);
    }

    private static boolean solution(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 1)
            return false;
        int x = nums[0];
        for (int i = 1; i < len ; i++) {
            if (x == nums[i])
                return true;
            x = nums[i];
        }
        return false;
    }
}
