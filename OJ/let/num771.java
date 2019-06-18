package Lettcode.let;

import java.util.HashSet;
import java.util.Set;

public class num771 {
    public static void main(String[] args) {
        String j = "aAaa";
        String s = "aAAbbbb";
        int ans = solution(j,s);
        System.out.println(ans);
    }

    private static int solution(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            char ch = J.charAt(i);
            set.add(ch);
        }
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (set.contains(ch))
                ++count;
        }
        return count;
    }
}
