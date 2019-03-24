package heima.Map;

/*
    Map集合的第一种遍历方式：通过键找值的方法
    Map集合中的方法：
        Set<K> keySet() 返回此映射中包含的键的Set视图
    实现步骤：
        1. 使用Map集合中的方法KeySet()，把Map集合所有的Key找出来，存储到一个Set集合中
        2. 遍历set集合，获取Map集合中的每一个个Key
        3. 通过Map集合中的方法get(key)，通过key找到value
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _02KeySet {
    public static void main(String[] args) {
        //创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        // 1. 使用Map集合中的方法keySet()，把Map集合所有的Key找出来，存储到一个Set集合中
        Set<String> set = map.keySet();
        // 2. 遍历集合
        for (String name:set){
            Integer age = map.get(name);
            System.out.println(name + " " + age);
        }

    }
}
