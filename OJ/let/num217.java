package Lettcode.let;

import java.util.Arrays;

public class num217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len <= 0)
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
