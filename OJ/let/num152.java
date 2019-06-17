package Lettcode.let;

public class num152 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            int x = max * nums[i];
        }
        return 0;
    }
}
