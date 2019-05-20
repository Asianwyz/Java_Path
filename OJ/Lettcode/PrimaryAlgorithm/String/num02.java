package Lettcode.PrimaryAlgorithms.LcString;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

public class num02 {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(solution(x));
    }

    private static int solution(int x) {
        if (x == -2147483648){
            return 0;
        }
        String s = "";
        if (x < 0){
            x = Math.abs(x);
            s = "-";
        }
        char[] ch = String.valueOf(x).toCharArray();
        solution(ch);
        String str = s + new String(ch);
        long l = Long.valueOf(str).longValue();
        int y = (int) l;
        if (y != l)
            return 0;
        return y;
    }

    private static void solution(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r){
            char ch = s[l];
            s[l++] = s[r];
            s[r--] = ch;
        }
    }
}
