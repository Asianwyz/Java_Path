package Lettcode.let;

import java.util.LinkedList;
import java.util.List;

public class num22 {
    static List<String> list = new LinkedList<>();
    static int m = 0;
    public static void main(String[] args) {
        int n = 1;
        solution(n);
        System.out.println(list);
    }

    private static void solution(int n) {
        m = n;
        list.clear();
        generate(0,0,"");
    }

    private static void generate(int x, int y, String s) {
        if (x == m && y == m){
            list.add(s);
            return;
        }
        if (x < m){
            generate(x + 1, y, s + '(');
        }
        if (y < m && y < x){
            generate(x, y + 1, s + ')');
        }
    }
}
