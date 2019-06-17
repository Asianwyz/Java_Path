package Lettcode.let;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num39 {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        solution(candidates,target);
    }

    private static void solution(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> ll = new LinkedList<>();
        Arrays.sort(candidates);
        add(candidates,0,target,ll,list);
//        return list;
    }

    private static void add(int[] nums, int x, int target, List<Integer> ll, List<List<Integer>> list) {
        if (target == 0){
            List<Integer> l = new LinkedList<>();
            for (Integer k:ll) {
                l.add(k);
            }
            list.add(l);
            return;
        }
        for (int i = x; i < nums.length; i++) {
            if (target < nums[i])
                break;
            ll.add(0,nums[i]);
            add(nums, i,target - nums[i],ll,list);
            ll.remove(0);
        }
    }
}
