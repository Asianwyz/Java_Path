package heima.List;

/*
    java.util.ArrayList 集合数据存储的结构是数组结构。元素增删慢，查找快，由于日常开发中使用最多的功能为查询数据、遍历数
    据，所以 ArrayList 是最常用的集合。
    许多程序员开发时非常随意地使用ArrayList完成任何需求，并不严谨，这种用法是不提倡的

    java.util.LinkedList集合 implements List 接口
    LinkedList集合的特点：
        1. 底层是一个链表结构：查询慢，增删快
        2. 里边包含了大量操作首尾元素的方法
        注意:使用LinkedList集合特有的方法，不能使用多态

        - public void adFirst(E e) : 将指定元素插入此列表的开头。
        - public void addLast(E e) : 将指定元素添加到此列表的结尾。
        - public E getFirst() : 返回此列表的第一个元素
        - public E getLast() : 返回此列表的最后一个元素
        - public E removeFirst() : 移除并返回此列表的第一个元素
        - public E removeLast() : 移除并返回此列表的最后一个元素
        - public E pop() : 从此列表所表示的堆栈出弹出一个元素
        - public void push(E e) : 将元素推入此列表所表示的堆栈
        - public boolean isEmpty() : 如果列表不包含元素， 则返回true
 */

import java.util.LinkedList;

public class _02LinkedList<S> {
    public static void main(String[] args) {
//        show01();
//        show02();
        show03();

    }

    /*
        - public void addFirst(E e):将指定元素插入此列表的开头。
        - public void addLast(E e):将指定元素添加到此列表的结尾。
        - public void push(E e):将元素推入此列表所表示的堆栈。此方法等效于 addFirst(E)。
    */
    private static void show01(){
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("s");
        linked.add("i");
        linked.add("a");
        System.out.println(linked);

//        linked.push("www.");
        linked.addFirst("www.");
        System.out.println(linked);

        linked.addLast(".com");
        System.out.println(linked);
    }

    /*
        - public E getFirst():返回此列表的第一个元素。
        - public E getLast():返回此列表的最后一个元素。
    */
    private static void show02(){
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("s");
        linked.add("i");
        linked.add("a");
        System.out.println(linked);

//        linked.clear();
        if (!linked.isEmpty()){
            String First = linked.getFirst();
            String Last = linked.getLast();
            System.out.println(First + "  " + Last);
        }
    }

    /*
       - public E removeFirst():移除并返回此列表的第一个元素。
       - public E removeLast():移除并返回此列表的最后一个元素。
       - public E pop():从此列表所表示的堆栈处弹出一个元素。此方法相当于 removeFirst
    */
    private static void show03(){
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("b");
        linked.add("s");
        linked.add("i");
        linked.add("a");
        System.out.println(linked);

        String first = linked.pop();
        System.out.println(first);
        System.out.println(linked);
        String last = linked.removeLast();
        System.out.println(last);
        System.out.println(linked);
    }
}

