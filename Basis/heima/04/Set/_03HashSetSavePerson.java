package heima.Set;

import java.util.HashSet;

/*
    HashSet 存储自定义类型
    set集合报错元素唯一：
        存储的元素（String, Integer, Student....) ， 必须重写hasCode方法和equals方法

    要求：同名和同年龄的人，只能存储一次
 */

public class _03HashSetSavePerson {
    public static void main(String[] args) {
        // 创建HashSet集合存储Person
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("周芷若",20);
        Person p2 = new Person("周芷若",20);
        Person p3 = new Person("周芷若",21);

        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        System.out.println(set);
    }
}
