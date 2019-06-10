package Lettcode.MiddleAlgorithms.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

public class num02 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int i = 0;
        int len = nums.length;
        while (i < len - 2){
            int j = len - 1;
            int index = i + 1;
            while (index < j){
                int sum = nums[i] + nums[j] + nums[index];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[index],nums[j]));
                    while (i < len - 2 && nums[i] == nums[i + 1]) i++;
                    while (j > index && nums[j] == nums[j - 1]) j--;
                    index++;
                    j--;
                    continue;
                }
                if (sum > 0){   j--;    }
                else {  index++;        }
            }
            i++;
        }
        return ans;
    }
}
