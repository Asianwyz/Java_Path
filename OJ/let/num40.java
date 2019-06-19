package Lettcode.let;

import java.util.*;

public class num40 {
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> list = solution(candidates,target);
        System.out.println(list);
    }

    private static List<List<Integer>> solution(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        boolean[] flag = new boolean[candidates.length];
        List<Integer> ll = new ArrayList<>();
        add(candidates,ll,0,target,list);
        return removeDuplicate(list);
    }

    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    private static void add(int[] candidates, List<Integer> ll, int x, int target, List<List<Integer>> list) {
        if (target == 0){
            List<Integer> l = new LinkedList<>();
            for (Integer k:ll) {
                l.add(k);
            }
            list.add(l);
            return;
        }
        for (int i = x; i < candidates.length; i++) {
            if (target < candidates[i])
                break;
            ll.add(0,candidates[i]);
            add(candidates,ll,i + 1,target - candidates[i],list);
            ll.remove(0);
        }
    }
}
