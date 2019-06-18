package Lettcode.let;

public class num125 {
    public boolean isPalindrome(String s) {
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
