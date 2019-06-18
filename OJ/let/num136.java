package Lettcode.let;

import java.util.HashSet;
import java.util.Set;

public class num136 {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int ans = solution(nums);
        System.out.println(ans);
    }

    private static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }
            else set.add(nums[i]);
        }
        return set.iterator().next();
    }
}
