package heima.Map;

import java.util.*;

/*
    计算一个字符串中每个字符出现的次数
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (map.containsKey(s)){
                Integer count = map.get(s);
                map.put(s,count+1);
            }
            else {
                map.put(s,1);
            }
        }
        Set<Character> set = map.keySet();
        for (Character ch:set){
            System.out.println(ch + " 出现的次数为： " + map.get(ch));
        }
    }
}
