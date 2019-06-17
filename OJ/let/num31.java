package Lettcode.let;

import java.util.Arrays;

public class num31 {
    public static void main(String[] args) {
        int[] nums = {5,1,1};
        nums = solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] solution(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            --i;
        if (i < 0){
            Arrays.sort(nums);
            return nums;
        }
        for (int j = nums.length - 1; j > i; j--) {
            if (nums[j] > nums[i]){
                swap(nums,i,j);
                break;
            }
        }
        int l = i + 1, r = nums.length - 1;
        while (l < r){
            swap(nums,l++,r--);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }
}
