package heima.List;

/*
    java.util.list接口 extends Collection接口
    List接口的特点：
        1. 有序的集合，存储元素和取出元素的顺序是一致的（存储123，取出123）
        2. 有索引，包含了一些带索引的方法
        3. 允许存储重复的元素

    List接口中带索引的方法（特有）
        - public boid add(int index, E element);将指定的元素，添加到该集合中的指定位置上。
        - public E get(int index);              返回集合中指定位置的元素。
        - public E remove(int index);           移除列表中指定位置的元素，返回的是被移除的元素。
        - public E set(int index, E element);   用指定的元素替换集合中指定位置的元素，返回值的更新前的元素。

    注意：
        操作索引的时候，一定要防止索引越界异常
        IndexOutOfBoundsException:索引越界异常,集合会报
        ArrayIndexOutOfBoundsException:数组索引越界异常
        StringIndexOutOfBoundsException:字符串索引越界异常
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _01List {
    public static void main(String[] args) {
        // 创建一个List对象， 多态
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        // 打印
        System.out.println(list);

        list.add(4,"asdfasf");
        System.out.println(list);

        String removeE = list.remove(2);
        System.out.println("被移除的元素：" + removeE);
        System.out.println(list);

        String setE = list.set(3,"B");
        System.out.println("被替换的元素：" + setE);
        System.out.println(list);

        // List 集合三种遍历方式
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("-----------------------");

        Iterator<String> s = list.iterator();
        while (s.hasNext()){
            System.out.println(s.next());
        }
        System.out.println("-----------------------");
        for (String ss:list) {
            System.out.println(ss);
        }

        String r = list.get(10); // IndexOutOfBoundsException
        System.out.println(r);
    }
}
