package Lettcode.let;

import java.util.Stack;

public class num20 {
    public static void main(String[] args) {
        String s = "{[]}";
        boolean ans = solution(s);
        System.out.println(ans);
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if (stack.empty())
                    return false;
                char cc = stack.peek();
                if (ch == ')') {
                    if (cc == '('){
                        stack.pop();
                    }
                    else return false;
                }
                else if (ch == '}') {
                    if (cc == '{'){
                        stack.pop();
                    }
                    else return false;
                }
                else if (ch == ']') {
                    if (cc == '['){
                        stack.pop();
                    }
                    else return false;
                }
            }
        }
        return true;
    }
}
