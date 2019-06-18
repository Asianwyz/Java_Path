package Lettcode.let;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int x = 0, y = 0;
        while (x < nums1.length && y < nums2.length){
            if (nums1[x]  == nums2[y]){
                list.add(nums1[x++]);
                ++y;
            }
            else if (nums1[x] > nums2[y]){
                ++y;
            }
            else ++x;
        }
        Integer[] ans = list.toArray(new Integer[list.size()]);
        int[] a = new int[ans.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans[i];
        }
        return a;
    }
}
