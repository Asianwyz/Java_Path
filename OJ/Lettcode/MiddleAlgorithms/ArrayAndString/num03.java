package Lettcode.MiddleAlgorithms.ArrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */


public class num03 {
    public static void main(String[] args) {
        String s = "aaabbba";
        int maxlen = solution(s);
        System.out.println(maxlen);
    }

    private static int solution(String s) {
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && start <= map.get(ch)){
                start = map.get(ch) + 1;
                len = i - map.get(ch);
            }
            else ++len;
            map.put(ch,i);
            max = len > max ? len : max;
        }
        return max;
    }
}
