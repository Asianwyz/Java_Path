package Lettcode.let;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num18 {
    public static void main(String[] args) {
        int[] nums = {-1,-5,-5,-3,2,5,0,4};
        int target = -7;
        List<List<Integer>> list = solution(nums,target);
        System.out.println(list);
    }

    private static List<List<Integer>> solution(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int k = 0; k <len - 3 ; k++) {
            int i = k + 1;
            while (i < len - 2){
                int j = len - 1;
                int index = i + 1;
                while (index < j){
                    int sum = nums[k] + nums[i] + nums[j] + nums[index];
                    if (sum == target){
                        ans.add(Arrays.asList(nums[k],nums[i],nums[index],nums[j]));
                        while (i < len - 2 && nums[i] == nums[i + 1]) i++;
                        while (j > index && nums[j] == nums[j - 1]) j--;
                        index++;
                        j--;
                        continue;
                    }
                    if (sum > target){   j--;    }
                    else {  index++;        }
                }
                i++;
            }
            while (k < len - 3 && nums[k] == nums[k + 1]) k++;
        }
        return ans;
    }


}
