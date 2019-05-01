package Lettcode.let;

import java.util.*;

public class num15 {
    public static void main(String[] args) {
        int[] nums = {3,0,-2,-1,1,2};
        List<List<Integer>> threeSum = threesum(nums);
        System.out.println(threeSum.toString());
    }

    private static List<List<Integer>> threesum(int[] nums) {
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
