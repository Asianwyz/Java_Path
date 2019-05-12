package Lettcode.PrimaryAlgorithms.Array;

import java.util.*;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */

public class num06 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] ans = solution(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solution(int[] nums1, int[] nums2) {
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
