package Lettcode.let;

import java.util.HashMap;
import java.util.Map;

public class num12 {

    static Map<Integer,String> map = new HashMap<>();
    static String s = "";

    public static void main(String[] args) {
        int num = 1995;
        String s = solution(num);
        System.out.println(s);
    }

    private static String solution(int num) {
        s = "";
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        while (num > 0){
            if (num >= 1000){
                num = add(num,1000);
            }
            else if (num >= 900){
                num = add(num,900);
            }
            else if (num >= 500){
                num = add(num,500);
            }
            else if (num >= 400){
                num = add(num,400);
            }
            else if (num >= 100){
                num = add(num,100);
            }
            else if (num >= 90){
                num = add(num,90);
            }
            else if (num >= 50){
                num = add(num,50);
            }
            else if (num >= 40){
                num = add(num,40);
            }
            else if (num >= 10){
                num = add(num,10);
            }
            else if (num >= 9){
                num = add(num,9);
            }
            else if (num >= 5){
                num = add(num,5);
            }
            else if (num >= 4){
                num = add(num,4);
            }
            else if (num >= 1){
                num = add(num,1);
            }
        }
        return s;
    }

    private static int add(int num, int i) {
        int x = num / i;
        String str = map.get(i);
        for (int j = 0; j < x; j++) {
            s += str;
        }
        return num - (x * i);
    }
}
