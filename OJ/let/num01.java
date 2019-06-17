package Lettcode.let;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class num01 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution(nums,target)));
    }

    private static int[] solution(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null){
                map.put(target - nums[i],i);
            }
            else{
                ans = new int[]{map.get(nums[i]), i};
            }
        }
        return ans;
    }

}
