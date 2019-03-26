package heima.Exception;

/*
    要求：模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册。
    分析:
        1. 使用数组保存已经注册过的用户名（数据可）
        2. 使用Scanner获取用户输入的注册的用户名（前端，页面)
        3. 定义一个方法，对用户输入的注册用户名进行判断
            遍历存储已经注册过用户名的数组，获取每一个用户名
            与注册用户名比较
                true：用户名已存在，抛出RegisterException异常，告知用户“亲，该用户名已经被注册”）
                false：继续遍历比较
            循环结束，没有重复，则加入，提示用户注册成功
 */

import java.util.Scanner;

public class _08RegisterException {

    // 1.使用数组保存已经注册过的用户名(数据库)
    static String[] usernames = {"张三","李四","王五"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您要注册的用户名");
        String username = in.next();
        checkUsername(username);
    }

    public static void checkUsername(String username){
        for (String name:usernames){
            if (name.equals(username)){
                try {
                    throw new RegisterException("亲，该用户名已经被注册");//抛出运行期异常,无需处理,交给JVM处理,中断处理
                } catch (RegisterException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("恭喜您，注册成功");
    }
//    public static void checkUsername(String username){
//        for (String name:usernames){
//            if (name.equals(username)){
//                throw new RegisterException("亲，该用户名已经被注册");//抛出运行期异常,无需处理,交给JVM处理,中断处理
//            }
//        }
//        System.out.println("恭喜您，注册成功");
//    }
}
