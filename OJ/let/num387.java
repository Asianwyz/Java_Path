package Lettcode.let;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num387 {
    public int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)){
                if (map.containsKey(ch)){
                    map.remove(ch);
                }
            }
            else{
                set.add(ch);
                map.put(ch,i);
            }
        }
        int ans = len;
        for (Integer index : map.values()) {
            ans = ans > index ? index : ans;
        }
        if (ans == len)
            return -1;
        return ans;
    }
}
