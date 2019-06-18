package Lettcode.let;

import java.util.HashMap;
import java.util.Map;

public class num242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        count(s,sMap);
        count(t,tMap);
        for (Character ch : sMap.keySet()) {
            Integer scount = sMap.get(ch);
            if (!tMap.containsKey(ch)){
                return false;
            }
            Integer tcount = tMap.get(ch);
            if (scount.intValue() != tcount.intValue()){
                System.out.println(ch + ":  " + scount + "  " + tcount);
                return false;
            }
        }
        return true;
    }

    private static void count(String t, Map<Character, Integer> tMap) {
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (tMap.containsKey(ch)){
                tMap.put(ch,tMap.get(ch) + 1);
            }
            else tMap.put(ch,1);
        }
    }
}
