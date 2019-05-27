package Lettcode.PrimaryAlgorithms.LcString;

/**
 * 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */

public class num08 {
    public static void main(String[] args) {
        int n = 30;
        String str = solution(n);
//        System.out.println(str);
    }

    private static String solution(int n) {
        String s = "1";
        int cycle = 1;
        while (cycle < n){
            ++cycle;
            s = count(s);
            System.out.println(s);
        }
        return s;
    }

    private static String count(String s) {
        String str = "";
        int len = s.length();
        int index = 0;
        int countNumber = 0;
        int lastNumber = 0;
        while (index < len){
            int number = (int) s.charAt(index) - 48;
            if (number != lastNumber){
                if (countNumber > 0){
                    str += (char)(countNumber + 48);
                    str += (char)(lastNumber + 48);
                }
                lastNumber = number;
                countNumber = 1;
            }
            else{
                ++countNumber;
            }
            ++index;
        }
        if (countNumber > 0){
            str += (char)(countNumber + 48);
            str += (char)(lastNumber + 48);
        }
        return str;
    }


}

