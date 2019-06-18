package Lettcode.let;

public class num344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r){
            char ch = s[l];
            s[l++] = s[r];
            s[r--] = ch;
        }
    }
}
