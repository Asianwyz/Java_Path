package heima.Generic;

/*
    测试含有泛型的接口
 */

public class _04GenericInterface {
    public static void main(String[] args) {
        // 创建GenericInterfaceImpl1 对象
        GenericInterfaceImpl1 gi1 = new GenericInterfaceImpl1();
        gi1.method("zifuasdf");

        // 创建GenericInterfaceImpl2 对象
        GenericInterfaceImpl2<Integer> gi2 = new GenericInterfaceImpl2<>();
        gi2.method(10);

        GenericInterfaceImpl2<Double> gi4 = new GenericInterfaceImpl2<>();
        gi4.method(8.989);
    }
}
