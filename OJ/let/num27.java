package Lettcode.let;

public class num27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int len = solution(nums,val);
        System.out.println(len);
    }

    private static int solution(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                count++;
            }
            else{
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }
}
