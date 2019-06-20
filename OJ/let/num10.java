package Lettcode.let;

public class num10 {
    public static void main(String[] args) {
        String s = "aa";
        String p = ".*";
        boolean flag = solution(s,p);
        System.out.println(flag);
    }

    private static boolean solution(String s, String p) {
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        f[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0 ; --i) {
            for (int j = p.length() - 1; j >= 0 ; j--) {
                boolean euqalone = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
                    f[i][j] = f[i][j + 2] || euqalone && f[i + 1][j];
                }
                else{
                    f[i][j] = euqalone && f[i + 1][j + 1];
                }
            }
        }
        return f[0][0];
    }
}
