package Lettcode.let;

public class num34 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,4};
        int target = 4;
        int[] index = solution(nums,target);
        System.out.println(index[0] + " " + index[1]);
    }

    private static int[] solution(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int index = -1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                index = mid;
                break;
            }
            if (nums[mid] < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        if (index == -1)
            return new int[]{-1, -1};
        int x = find(nums,0,index - 1,target);
        if (x == -1){
            x = index;
        }
        int y = find1(nums,index + 1,nums.length - 1,target);
        if (y == -1){
            y = index;
        }
        return new int[]{x,y};
    }

    private static int find1(int[] nums, int x, int y, int target) {
        int j = -1;
        while (x <= y){
            int mid = (x + y + 1) / 2;
            if (nums[mid] == target){
                x = mid;
                j = x;
                if (x == y)
                    break;
            }
            else if (nums[mid] > target){
                y = mid - 1;
            }
            else x = mid + 1;
        }
        return j;
    }

    private static int find(int[] nums, int x, int y, int target) {
        int i = -1;
        while (x <= y){
            int mid = (x + y) / 2;
            if (nums[mid] == target){
                y = mid;
                i = y;
                if (x == y)
                    break;
            }
            else if (nums[mid] > target){
                y = mid - 1;
            }
            else x = mid + 1;
        }
        return i;
    }
}
