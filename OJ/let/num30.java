package Lettcode.let;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num30 {
    public static void main(String[] args) {
        String s = "mississippi";
        String[] words = {"is"};
        List<Integer> list = solution(s,words);
        System.out.println(list);
    }

    private static List<Integer> solution(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length < 1 || s.length() < 1 || s == null)
            return list;
        if (words.length == 1){
            if (s.equals(words[0])){
                list.add(0);
                return list;
            }
        }
        int len = words[0].length();
        if (s.length() < (len * words.length))
            return list;
        Map<String,Integer> mapword = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (mapword.containsKey(words[i])){
                mapword.put(words[i],mapword.get(words[i]) + 1);
            }
            else mapword.put(words[i], 1);
        }
        Map<String,Integer> map = new HashMap<>();
        int end = s.length() - (len * words.length);
        for (int i = 0; i <= end; i++) {
            map.clear();
            String str = s.substring(i,i + (len * words.length));
            boolean flag = true;
            for (int j = 0; j < str.length(); j += len) {
                String ss = str.substring(j,j + len);
                if (!mapword.containsKey(ss)){
                    flag = false;
                    break;
                }
                if (map.containsKey(ss)){
                    map.put(ss,map.get(ss) + 1);
                }
                else map.put(ss, 1);
                if (map.get(ss) > mapword.get(ss)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(i);
            }
        }
        return list;
    }
}
