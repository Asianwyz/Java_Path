package Lettcode.let;

import java.util.HashMap;
import java.util.Map;

public class num13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int x = solution(s);
        System.out.println(x);
    }

    private static int solution(String s) {
        int x = 0;
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        int index = 0;
        int len = s.length();
        while (index < len - 1){
            String ss = s.substring(index,index + 2);
            if (map.containsKey(ss)){
                x += map.get(ss);
                index += 2;
            }
            else{
                String str = "" + s.charAt(index);
                x += map.get(str);
                index++;
            }
        }
        if (index < len){
            String str = "" + s.charAt(index);
            x += map.get(str);
        }
        return x;
    }
}
