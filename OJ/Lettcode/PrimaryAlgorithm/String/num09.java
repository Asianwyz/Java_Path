package Lettcode.PrimaryAlgorithms.LcString;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */

public class num09 {
    public static void main(String[] args) {
        String[] strs = {"ab","aa","ac"};
        String longestCommonPrefix = solution(strs);
        System.out.println(longestCommonPrefix);
    }

    private static String solution(String[] strs) {
        int len = strs.length;
        if (len < 1)
            return "";
        if (len == 1)
            return strs[0];
        int l = 0, r = strs[0].length();
        String ansprefix = "";
        while (l < r){
            int mid = (l + r) / 2;
            String prefix = strs[0].substring(0,mid + 1);
            boolean flag = false;
            for (int i = 1; i < len; i++) {
                if (strs[i].indexOf(prefix) != 0){
                    r = mid;
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            l = mid + 1;
            ansprefix = ansprefix.length() < prefix.length() ? prefix : ansprefix;
        }
        return ansprefix;
    }
}
