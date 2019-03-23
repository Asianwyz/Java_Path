package heima.Collection;

import java.util.Collection;
import java.util.HashSet;

/*
    java.utli.Collection 接口
        所有单列集合的最顶层的接口，里边定义了所有单列集合共性的方法
        任意的单列集合都可以使用Collection接口中的方法

    共性的方法：
        public boolean add(E e) : 把给定的对象添加到当前集合中。
        public void clear() : 清空集合中所有的元素。
        public boolean remove(E e) : 把给定的对象在当前集合中删除。
        public boolean contains(E e) : 判断当前集合中是否包含给定的对象。
        public boolean isEmpty() : 判断集合是否为空
        public int size() : 返回集合元素个数
        public Object[] to Array() : 把元素中的元素，存储到数组中
 */

public class demoCollection {
    public static void main(String[] args) {

        Collection<String> coll = new HashSet<>();
        System.out.println(coll);

        /*
            public boolean add(E e);  把给定的对象添加到当前集合种
            返回值是一个Boolean值，一般都返回true值，所以可以不用接收
         */
        boolean b1 = coll.add("Asia");
        System.out.println("b1" + b1);
        System.out.println(coll);
        coll.add("asdfba");
        coll.add("asdasfa");
        coll.add("abcsdfa");
        coll.add("basdfa");
        System.out.println(coll);

        /*
            public boolean remoeve(E e): 把给定的对象在当前集合种删除。
            返回值是一个Boolean值，集合中存在元素，删除元素，返回true
                                         不存在元素，删除失败，返回false
         */
        boolean b2 = coll.remove("Asia");
        System.out.println("b2" + b2);

        boolean b3 = coll.remove("asdfasdfasf");
        System.out.println("b3" + b3);
        System.out.println(coll);

        /*
            public boolean contains(E e) : 判断当前集合中是否包含给定的对象
            包含返回true，不包含返回false
         */
        boolean b4 = coll.contains("basdfa");
        System.out.println("b4" + b4);
        boolean b5 = coll.contains("basdfasdfasdfa");
        System.out.println("b5" + b5);

        // public boolean isEmpty() : 判断当前集合是否为空。为空返回true，否则返回false
        boolean b6 = coll.isEmpty();
        System.out.println("b6" + b6);

        // public int size();   返回集合中元素的个数
        int size = coll.size();
        System.out.println("size" + size);

        // public Object[] toArray(): 把集合中的元素，存储到数组中。
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // public void clear() : 清空集合中所有的元素。 但是不删除集合，集合还存在
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());
    }
}
