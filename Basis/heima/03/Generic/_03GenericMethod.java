package heima.Generic;

/*
    测试含有泛型的方法
 */

public class _03GenericMethod {
    public static void main(String[] args) {

        // 创建GenericMethod对象
        GenericMethod gm = new GenericMethod();

        /*
            调用含有泛型的方法method1
            传递什么类型，泛型就是什么类型
         */
        gm.method1("asdfa");
        gm.method1(13323);
        gm.method1(8.9);
        gm.method1(true);

        gm.method2("静态方法，不建议创建对象使用");

        // 静态方法，通过类名.方法名(参数)可以直接使用
        GenericMethod.method2("静态方法");
        GenericMethod.method2(1);

    }
}
