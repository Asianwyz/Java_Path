package Lettcode.let;

import java.util.ArrayList;
import java.util.List;

public class num51 {

    static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        solution(n);
        System.out.println(list);
    }

    private static void solution(int n) {
        list.clear();
        int[] record = new int[n];
        find(0,record,n);
    }

    private static void find(int i, int[] record, int n) {
        if (i == n){
            List<String> ll = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String s = "";
                for (int k = 0; k < n; k++) {
                    if (k == record[j]){
                        s += 'Q';
                    }
                    else s += '.';
                }
                ll.add(s);
            }
            list.add(ll);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(record,i,j)){
                record[i] = j;
                find(i + 1,record,n);
            }
        }
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }
}
