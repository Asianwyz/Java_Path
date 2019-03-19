package heima.day07;

import java.util.Scanner;


/*
    Scanner 类的功能：可以实现键盘输入数据，到程序当中
引用类型的一般使用步骤：
    1. 导包
    2. 创建
    3. 使用

    获取键盘输入的一个int数字： int num = in.nextInt();
    获取键盘输入的一个字符串：String str = sc.next();
 */
public class Demo01Scanner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
    }
}
