package Lettcode.PrimaryAlgorithms.LcString;

/**
 *  验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */

public class num05 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
                if (ch >= 'A' && ch <= 'Z'){
                    str += ((char) (ch + 32));
                }
                else str += ch;
            }
        }
        return  chcek(str.toCharArray());
    }

    private static boolean chcek(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r){
            if(s[l] != s[r])
                return false;
            ++l;
            --r;
        }
        return true;
    }
}
