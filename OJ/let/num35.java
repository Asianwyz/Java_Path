package Lettcode.let;

public class num35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        int index = solution(nums,target);
        System.out.println(index);
    }

    private static int solution(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return r;
    }
}
