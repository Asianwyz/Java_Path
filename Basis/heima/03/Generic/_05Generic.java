package heima.Generic;

/*
    泛型的通配符：
        ？：代表任意的数据类型
    使用方式：
        不能创建对象使用
        只能作为方法的参数使用
 */

import java.util.ArrayList;
import java.util.Iterator;

public class _05Generic {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(2);

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("as");
        list02.add("asasdf");

        printArray(list01);
        printArray(list02);

    }

    /*
        定义一个方法，能遍历所有类型的ArrayList集合
        这时候我们不知道ArrayList集合使用什么数据类型，可以泛型的通配符 ？ 来接受收据类型
        注意：
            泛型是没有继承概念的
     */

    public static void printArray(ArrayList<?> list){
        // 使用迭代器遍历集合
        Iterator<?> it = list.iterator();
        while (it.hasNext()){
            // it.next()方法，取出的元素是Object，可以接收任意的数据类型
            Object o = it.next();
            System.out.println(o);
        }
    }
}
