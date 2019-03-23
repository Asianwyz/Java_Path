package heima.Generic;

public class _02GenericClass {
    public static void main(String[] args) {

        //不写泛型默认为Object类型
        GenericClass gc = new GenericClass();
        gc.setName("只能是字符串");
        Object obj = gc.getName();
        System.out.println(obj);

        // 创建GenericClass对象，泛型使用Integer类型
        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setName(1);

        Integer name = gc2.getName();
        System.out.println(name);

        // 创建GenericClass对象，泛型使用String对象
        GenericClass<String> gc3 = new GenericClass<>();
        gc3.setName("Asia");
        String names = gc3.getName();
        System.out.println(names);
    }
}
