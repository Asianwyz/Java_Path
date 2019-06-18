package Lettcode.let;

public class num283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int[] flag = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0){
                flag[i] = -1;
                ++count;
                continue;
            }
            else
                flag[i] = count;
        }
        for (int i = 0; i < len; i++) {
            if (flag[i] == -1)
                continue;
            nums[i - flag[i]] = nums[i];
        }
        for (int i = len - 1; i >= len - count ; i--) {
            nums[i] = 0;
        }
    }
}
