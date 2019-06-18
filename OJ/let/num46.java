package Lettcode.let;

import java.util.ArrayList;
import java.util.List;

public class num46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = solution(nums);
        System.out.println(list);
    }

    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        qpl(list,ll,flag,nums,0);
        return list;
    }

    private static void qpl(List<List<Integer>> list, List<Integer> ll, boolean[] flag, int[] nums, int x) {
        if (x == nums.length){
            List<Integer> l = new ArrayList<>();
            for (Integer k:ll) {
                l.add(k);
            }
            list.add(l);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i])
                continue;
            flag[i] = true;
            ll.add(0,nums[i]);
            qpl(list,ll,flag,nums,x + 1);
            flag[i] = false;
            ll.remove(0);
        }
    }
}
