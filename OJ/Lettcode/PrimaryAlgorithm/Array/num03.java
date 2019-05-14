package Lettcode.PrimaryAlgorithms.Array;

/**
 *   旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */

//输入: [1,2,3,4,5,6,7] 和 k = 3
//        输出: [5,6,7,1,2,3,4]
//        解释:
//        向右旋转 1 步: [7,1,2,3,4,5,6]
//        向右旋转 2 步: [6,7,1,2,3,4,5]
//        向右旋转 3 步: [5,6,7,1,2,3,4]

import java.util.Arrays;

public class num03 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        solution(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * n * k 算法 慢
     * @param nums
     * @param k
     */
    private static void solution(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int len = nums.length;
            int x = nums[len - 1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = x;
        }
    }
}
