package heima.Set;

/*
    Set 不允许存储重复元素的原理
 */

import java.util.HashSet;

public class _02Set {
    public static void main(String[] args) {

        // 创建HashSet对象
        HashSet<String> set = new HashSet<>();
        String s1 = new String("abc");
        String s2 = new String("abc");

        set.add(s1);
        set.add(s2);
        set.add("重地");
        set.add("通话");
        set.add("abc");
        System.out.println(set);

    }
}
