package Lettcode.let;

import java.util.LinkedList;
import java.util.List;

public class num17 {

    static String[] ss = {"","","abc","def","ghl","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> list = new LinkedList<>();

    public static void main(String[] args) {
        String digits = "";
        solution(digits);
        System.out.println(list);
    }

    private static void solution(String digits) {
        list.clear();
        if (digits.equals(""))
            return;
        assemble(0,digits,"");
    }

    private static void assemble(int i, String digits, String s) {
        if (i == digits.length()){
            list.add(s);
            return;
        }
        char ch = digits.charAt(i);
        String str = ss[((int) ch) - 48];
        for (int j = 0; j < str.length(); j++) {
            assemble(i + 1,digits,s + str.charAt(j));
        }
    }


}
