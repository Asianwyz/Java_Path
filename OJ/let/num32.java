package Lettcode.let;

public class num32 {
    public static void main(String[] args) {
        String s = "))))))()((()(((()((()((())()((()))()()(()()))))()())()))())())))(((()()()()(()()))()((()))))()(()()(((()())(((())(((())((()))))()(()(())(()(()(((((())(())))(()))())(((((())))))))()(())((((((()())()))))(()))(((()()(()(())()((())))()(())))())()())((((()))))()()((((((())()((((()(())((((()()())(())()())))()(()((())))))))()())((((()))())())))()))((())))()((()(())((()((())))((())((()())()))))())))())(((((((()))(((())(((()((()))(((()(())))((((()()())))))))())()))(()))())))()(()))((())()))((())))((())(()())(((()((()()))))()()(())))))()))))()((()((()(((()())(((())))(()(())())))((((((()()()))))((()))))(()(())()(()((())((()))()()()()(()((()())((((())()((()()))()))))()(((()())())))(()(((()()))()())))()()))))((()((((()(()))()(()()(((()()()()())((())()(((())(())))))()))))()())()()())(())))((())(()))(((())()))))))())()())((()((()()(())))())((()(((()(((((()(())(())()()))()))(()((((((((()(()()))()(()(()))(())(())())))))(())))))))()))))()())()()(((())()))((()))))))(())((()))(()((()()())())((()))))((()()())(()(((()))))(())(((()(()()()()((())())(())()))()())))())))()(((()))(()))()))()((((()()()(()(()))(((())()()(((())()((()(())((())())(((()()))((()())))())(()(())(()()))(((()(())(())))(()())(()()()()(()((()()()))(())(()(((()())))()((((())()())((()(()(())))(()()(()(()))))))(()())((()))()))()(()))((()()))))()()()))(())(())(())))()(()))(()()(((()((((())())))(()(())(()()))))))((()((()()))())))((((((())()))())(())())(()()(()(()()))()))((()((())(()((()(())))()((()))()(((()()()())()((())))(()()()()(()((()()((()((()()()(()(((())))))(())(()()(()())((((()()()()((()(())()(((()))(()(())(((()())())((()()))(";
        int len = solution1(s);
        System.out.println(len);
    }

    private static int solution1(String s) {
        int max = 0;
        int len = s.length();
        int[] f = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    f[i] = (i > 1 ? f[i - 2] : 0) + 2;
                }
                else{
                    if (i - f[i - 1] - 1 >= 0 && s.charAt(i - f[i - 1] - 1) == '('){
                        f[i] = f[i - 1] + ((i - f[i - 1]) > 1 ? f[i - f[i - 1] - 2] : 0) + 2;
                    }
                }
                max = max < f[i] ? f[i] : max;
            }
        }
        return max;
    }

    /**
     * 超时动规
     * @param s
     * @return
     */
    private static int solution(String s) {
        int len = s.length();
        int[][] f = new int[len][len];
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')')
                f[i][i + 1] = 2;
        }
        for (int k = 3; k <= len ; k++) {
            boolean flag = k % 2 == 0;
            for (int i = 0; i <= len - k; i++) {
                int j = i + k - 1;
                f[i][j] = Math.max(f[i][j-1],f[i + 1][j]);
                if (flag && s.charAt(i) == '(' && s.charAt(j) == ')'){
                    if (f[i + 1][j - 1] == k - 2){
                        f[i][j] = k;
                    }
                    else{
                        for (int t = i + 1; t < j ; t += 2) {
                            if (f[i][t] + f[t + 1][j] == k){
                                f[i][j] = k;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return f[0][len - 1];
    }
}
