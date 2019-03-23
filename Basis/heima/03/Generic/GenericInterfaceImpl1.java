package heima.Generic;

/*
    含有泛型的接口，第一种使用方式：定义接口的实现类，实现接口，指定接口的泛型
    public interface Interator<E> {
        E next();
    }

    Scanner 类实现了Interator接口，并指定接口的类型为String，所以重写的next方法泛型默认为String
    public final class Scanner implements Iterator<String>{

    }
 */

public class GenericInterfaceImpl1 implements GenericInterface<String>{
    @Override
    public void method(String s){
        System.out.println(s);
    }
}
