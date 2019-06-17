package Lettcode.let;

public class num33 {
    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;
        int index = solution(nums,target);
        System.out.println(index);
    }

    private static int solution(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (nums[mid] >= nums[0]){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }

        int ans = find(nums,0,r - 1,target);
        if (ans > -1){
            return ans;
        }
        ans = find(nums,r,nums.length - 1,target);
        return ans;
    }

    private static int find(int[] nums, int x, int y, int target) {
        while (x <= y){
            int mid = (x + y) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target){
                y = mid - 1;
            }
            else x = mid + 1;
        }
        return -1;
    }
}
