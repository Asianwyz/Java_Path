package heima.day07.demoArray.practice;

import java.util.ArrayList;

/*
对象添加到集合
自定义4个学生对象,添加到集合,并遍历
 */
public class P02ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student one = new Student("洪七公", 20 ,1);
        Student two = new Student("张三丰", 30 ,2);
        Student three = new Student("张无忌", 40 ,3);
        Student four = new Student("欧阳修", 50 ,4);

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("姓名：" + stu.getName());
            System.out.println("年龄：" + stu.getAge());
        }
    }
}
