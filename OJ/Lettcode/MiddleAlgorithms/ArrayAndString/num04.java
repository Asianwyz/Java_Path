package Lettcode.MiddleAlgorithms.ArrayAndString;

public class num04 {
    public static void main(String[] args) {
        String s = "";
        s = solution(s);
        System.out.println(s);
    }

    /**
     * 官方题解：中心扩展法
     * @param s
     * @return
     */
    private static String solution(String s) {
        if (s == "")
            return "";
        int len = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = enpand(s,i,i);
            int len2 = enpand(s,i,i + 1);
            len = Math.max(len1,len2);
            if (len > end - start){
                start = i - (len - 1)/ 2;
                end = start + len - 1;
            }
        }
        return s.substring(start,end + 1);
    }

    private static int enpand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            --l;
            ++r;
        }
        return r - l - 1;
    }
}
