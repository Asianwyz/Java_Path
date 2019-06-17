package Lettcode.let;

public class num04 {
    public static void main(String[] args) {
        int[] nums1 = {3,32,323};
        int[] nums2 = {1,3,434344};
        double zws = solution(nums1,nums2);
        System.out.println(zws);
    }

    private static double solution(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n){
            int[] tmp = nums1;nums1 = nums2;nums2 = tmp;
            int swap = m;m = n;n = swap;
        }
        int l = 0;
        int r = m;
        int half = (m + n + 1) / 2;
        while (l <= r){
            int i = (l + r) / 2;
            int j = half - i;
            if (i < r && nums2[j - 1] > nums1[i]){
                l = i + 1;
            }
            else if (i > l && nums2[j] < nums1[i - 1]){
                r = i - 1;
            }
            else{
                int zws = 0;
                if (i == 0){
                    zws = nums2[j - 1];
                }
                else if (j == 0){
                    zws = nums1[i - 1];
                }
                else zws = Math.max(nums2[j - 1],nums1[i - 1]);
                if ((m + n) % 2 == 1) return zws;

                int zwsr = 0;
                if (i == m){
                    zwsr = nums2[j];
                }
                else if (j == n){
                    zwsr = nums1[i];
                }
                else{
                    zwsr = Math.min(nums2[j], nums1[i]);
                }
                return (zws + zwsr) / 2.0;
            }
        }
        return 0.0;
    }
}
