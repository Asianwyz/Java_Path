package Lettcode.PrimaryAlgorithms.LcString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */

public class num03 {
    public static void main(String[] args) {
        String s = "lovelove";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)){
                if (map.containsKey(ch)){
                    map.remove(ch);
                }
            }
            else{
                set.add(ch);
                map.put(ch,i);
            }
        }
        int ans = len;
        for (Integer index : map.values()) {
            ans = ans > index ? index : ans;
        }
        if (ans == len)
            return -1;
        return ans;
    }
}
