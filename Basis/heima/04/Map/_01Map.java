package heima.Map;

/*
    java.util.Map<k,v> 集合
    Map集合的特点:
        1. Map 集合是一个双列集合，一个元素包含两个值（一个key，一个value）
        2. Map 集合中的元素， key和value的数据类型可以相同，也可以不同
        3. Map 集合中的元素，key是不允许重复的，value是可以重复的
        4. Map 集合中的元素，key和value是一一对应
    java.util.HashMap<k,v> 集合 implements Map<k,v> 接口
    HashMap的特点：
        1. HashMap集合底层是哈希表：查询的速度特别的快
            JDK1.8之前：数组+单向链表
            JDK1.8之后：数组+单向链表|红黑树（链表的长度超过8）：提高查询的速度
        2. HashMap集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致
    java.util.LinkedHashMap<k,v> 集合 extends HashMap<k,v>
    LinkedHashMap的特点：
        1. LinkedHashMap集合底层是哈希表+链表（保证迭代的顺序）
        2. LinkedHashMap集合是一个有序的集合，存储元素和取出元素的顺序是一致的
 */

import java.util.HashMap;
import java.util.Map;

public class _01Map {
    public static void main(String[] args) {
        show4();
    }

    /*
        boolean containsKey(Object key) 判断集合中是否包含指定的键
        包含返回true，不包含返回false
     */
    private static void show4(){
        //创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        boolean flag = map.containsKey("林志玲");
        boolean flag1 = map.containsKey("林志玲baby");
        System.out.println(flag + "  " + flag1);
    }

    /*
        public V get(Object key) 根据指定的键，在Map集合中获取对应的键
            返回值：
                key存在，返回对应的value值
                   不存在，返回null
    */

    private static void show3(){
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        Integer height = map.get("林志玲");
        System.out.println(height);
        Integer height1 = map.get("林b志玲");
        System.out.println(height1);


    }

    /*
        public V remove(Object key): 把指定的键所对应的键值对元素在Map集合中删除，返回被删除元素的值。
            返回值：v
                key存在，v返回被删除的值
                key不存在，返回null
     */
    private static void show2(){
        Map<String,Integer> map = new HashMap<>();
        map.put("Asia",18);
        map.put("Cost",18);
        map.put("Belly",22);
        System.out.println(map);

        int age = map.remove("Cost");
        System.out.println(age);
        System.out.println(map);
    }

    /*
        public V put(K key,V value): 把指定的键与指定的值添加到Map集合中
            返回值V：
                存储键值对的时候，key不重复，返回值v是null
                存储键值对的时候，key重复，会使用新的value替换map中重复的value，返回被替换的value值
     */
    private static void show1(){
        // 创建Map集合对象，多态
        Map<String,String> map = new HashMap<>();

        String v1 = map.put("Asia","1232");
        System.out.println("v1: " + v1);

        String v2 = map.put("Asia","asdf");
        System.out.println("v2: " + v1);

        System.out.println(map);

        map.put("1","2");
        map.put("2","4");
        map.put("3","6");
        System.out.println(map);
    }

}
