package heima.Iterator;

/*
    增强for循环：底层使用的也是迭代器，使用for循环的格式，简化了得带其的书写
    是JDK1.5以后出现的新特性
    Collection<E> extends Iterable<E> ： 所有的单列集合都可以使用增强for
    public interface Iterable<T> 实现这个接口允许对象成为“foreach”语句的目标。
    增强for循环：
        格式：
            for (集合/数组的数据类型 变量名: 集合名/数组名）{
                ......
            }
 */

import java.util.ArrayList;

public class Foreach {

    public static void main(String[] args) {

        demo01();
        demo02();
    }

    // 增强for循环遍历集合
    private static void demo02(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        for (String s: list){
            System.out.println(s);
        }

    }

//    增强for循环输出数组
    private static void demo01(){
        int[] arr = {1,2,3,4,5};
        for (int i:arr){
            System.out.println(i);
        }
    }
}
