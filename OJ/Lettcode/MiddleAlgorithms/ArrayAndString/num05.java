package Lettcode.MiddleAlgorithms.ArrayAndString;

/**
 *  递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */

public class num05 {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        boolean flag = solution1(nums);
        System.out.println(flag);
    }

    private static boolean solution1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mintwo = Integer.MAX_VALUE;
        for (int x:nums) {
            if (x <= min){
                min = x;
            }
            else if (x <= mintwo){
                mintwo = x;
            }
            else return true;
        }
        return false;
    }

    /**
     * 空间复杂度为O(n)，不满足题目要求
     * @param nums
     * @return
     */
    private static boolean solution(int[] nums) {
        int len = nums.length;
        int[] min = new int[len];
        int[] max = new int[len];
        min[0] = nums[0];
        max[len - 1] = nums[len - 1];
        for (int i = 1; i < len ; i++) {
            min[i] = Math.min(min[i - 1],nums[i - 1]);
        }
        for (int i = len - 2; i >= 0 ; --i) {
            max[i] = Math.max(max[i + 1],nums[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > min[i] && nums[i] < max[i])
                return true;
        }
        return false;
    }
}
