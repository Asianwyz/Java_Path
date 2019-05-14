package Lettcode.PrimaryAlgorithms.Array;

/**
 *   移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

import java.util.Arrays;

public class num08 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void solution(int[] nums) {
        int len = nums.length;
        int[] flag = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0){
                flag[i] = -1;
                ++count;
                continue;
            }
            else
                flag[i] = count;
        }
        for (int i = 0; i < len; i++) {
            if (flag[i] == -1)
                continue;
            nums[i - flag[i]] = nums[i];
        }
        for (int i = len - 1; i >= len - count ; i--) {
            nums[i] = 0;
        }
    }
}
