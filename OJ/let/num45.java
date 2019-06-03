package Lettcode.let;

import java.util.*;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 */

public class num45 {
    public static void main(String[] args) {
        int[] nums = new int[25002];
        for (int i = 0; i < 25001 ; i++) {
            nums[i] = 25000 - i;
        }
        nums[25001] = 0;
        nums[25000] = 1;
        System.out.println(Arrays.toString(nums));
        long start = System.nanoTime();
        System.out.println(solution(nums));
        long end = System.nanoTime();
        System.out.println("用时：" + (end - start));
    }

    private static int solution(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 0;
        boolean[] isReached = new boolean[len];
        LinkedList<Integer> reached = new LinkedList<>();
        reached.add(0);
        boolean flag = true;
        int steps = 0;
        while (flag){
            ++steps;
            int size = reached.size();
            while (size > 0){
                --size;
                int index = reached.poll();
                for (int i = index + nums[index] < len - 1 ? nums[index] : len - 1; i > index; --i) {
                    int canReached = i;
                    if (canReached == len - 1){
                        flag = false;
                        break;
                    }
                    if (!isReached[canReached]){
                        isReached[canReached] = true;
                        reached.add(canReached);
                    }
                    else continue;
                }
            }
        }
        return steps;
    }
}

//    private static int solution(int[] nums) {
//        int len = nums.length;
//        int[] minTimes = new int[len];
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = 1; j <= nums[i]; j++) {
//                if (i + j < len){
//                    if (minTimes[i + j] == 0){
//                        minTimes[i + j] = minTimes[i] + 1;
//                    }
//                    else minTimes[i + j] = minTimes[i + j] > minTimes[i] + 1 ? minTimes[i] + 1 : minTimes[i + j];
//                }
//            }
//        }
//        return minTimes[len - 1];
//    }
//}
