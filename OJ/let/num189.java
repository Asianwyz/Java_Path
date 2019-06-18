package Lettcode.let;

public class num189 {
    public void rotate(int[] nums, int k) {
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
