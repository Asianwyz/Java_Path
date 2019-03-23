package heima.day07.demoArray.practice;

/*
打印集合方法
定义以指定格式打印集合的方法(ArrayList类型作为参数)，使用{}扩起集合，使用@分隔每个元素。格式参照 {元素
@元素@元素}。
 */

import java.util.ArrayList;

public class P03ArrayListPrint {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("杨过");
        list.add("赵敏");
        list.add("张无忌");

        printArrayList(list);
    }

    /*
    定义方法三要素：
    返回值类型：void
    方法名称：printArrayList
    参数列表：ArrayList
     */

    public static void printArrayList(ArrayList<String> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (i != list.size() - 1){
                System.out.print(name + '@');
            }
            else{
                System.out.print(name + '}');
            }
        }
    }

}
