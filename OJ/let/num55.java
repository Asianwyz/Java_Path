package Lettcode.let;

public class num55 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean flag = solution(nums);
        System.out.println(flag);
    }

    private static boolean solution(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur < i){
                cur = next;
            }
            if (cur >= i){
                next = Math.max(next,i + nums[i]);
            }
        }
        if (cur >= nums.length - 1)
            return true;
        return false;
    }
}
