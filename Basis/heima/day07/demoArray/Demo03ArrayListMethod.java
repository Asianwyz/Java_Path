package heima.day07.demoArray;

/*
ArrayList当中的常用方法：
对于ArrayList集合来说，add一定会成功
public boolean add(E e);        向集合当中添加元素，参数的类型和泛型一致
public E get(int index);        从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素
public E remove(int index);     从集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素
public int size();              获取集合的尺寸长度，返回值是几何中包含的元素个数
 */

import java.util.ArrayList;

public class Demo03ArrayListMethod {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        boolean success = list.add("Asia");
        list.add("Asia1");
        list.add("Asia2");
        list.add("Asia3");
        list.add("Asia4");
        System.out.println(list);
        System.out.println("添加是否成功: " + success);

        // 从集合中获取元素
        String name = list.get(1);
        System.out.println(name);

        // 从集合中删除元素
        String whoRemoved = list.remove(2);
        System.out.println("被删除的人是：" + whoRemoved);
        System.out.println(list);

        // 获取集合的长度尺寸，也就是其中元素的个数
        int size = list.size();
        System.out.println("集合的长度是：" + size);



    }
}
