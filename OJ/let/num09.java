package Lettcode.let;

public class num09 {
    public static void main(String[] args) {
        int x = 1221;
        System.out.println(checsk(x));
    }

    private static boolean checsk(int x) {
        if (x < 0)
            return false;
        String s = Integer.toString(x);
        int l = 0, r = s.length() - 1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
