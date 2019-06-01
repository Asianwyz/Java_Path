package Lettcode.competition._2019_6_1_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num02 {
    public static void main(String[] args) {
        String text = "ababa";
        String[] words = {"aba","ab"};
        int[][] ans = solution(text,words);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    private static int[][] solution(String text, String[] words) {
        Set<int[]> set = new HashSet<>();
        int n = 0;
        for (int i = 0; i < words.length; i++) {
            String s = text;
            char ch = words[i].charAt(0);
            int begin = s.indexOf(ch);
            int len = words[i].length();
            while (begin >= 0){
                if (begin + len > s.length())
                    break;
                if (s.substring(begin,begin + len).equals(words[i])){
                    int[] f = {begin,begin + len -1};
                    set.add(f);
                    ++n;
                }
                s = s.substring(0,begin) + " " + s.substring(begin + 1);
                begin = s.indexOf(ch);
            }
        }
        int[][] ans = new int[n][2];
        int index = 0;
        for (int[] f:set) {
            ans[index++] = f;
        }
        qsort(ans,0,n - 1);
        return ans;
    }

    private static void qsort(int[][] arr, int l, int r) {
        if (l < r){
            swap(arr,l + (int)(Math.random() * (r - l + 1)), r);
            int[] p = partition(arr,l,r);
            qsort(arr,l,p[0] - 1);
            qsort(arr,p[1] + 1,r);
        }
    }

    private static int[] partition(int[][] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more){
            if (arr[l][0] > arr[r][0] || (arr[l][0] == arr[r][0] && arr[l][1] > arr[r][1])){
                swap(arr,l,--more);
            }
            else if (arr[l][0] < arr[r][0] || (arr[l][0] == arr[r][0] && arr[l][1] < arr[r][1])){
                swap(arr,++less,l++);
            }
            else{
                ++l;
            }
        }
        swap(arr,more,r);
        return new int[] {less + 1, more};
    }

    private static void swap(int[][] arr, int j, int i) {
        int[] x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }
}
