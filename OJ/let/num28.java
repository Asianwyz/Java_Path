package Lettcode.let;

public class num28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        char firstChOfneedle = needle.charAt(0);
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len ; i++) {
            if (firstChOfneedle != haystack.charAt(i))
                continue;
            if (haystack.substring(i,i+len).equals(needle))
                return i;
        }
        return -1;
    }
}
