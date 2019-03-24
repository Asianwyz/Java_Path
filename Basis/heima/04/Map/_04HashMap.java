package heima.Map;

/*
    HashMap存储自定义类型键值
    Map集合保证Key是唯一的：
        作为Key的元素，必须重写hashCode方法和equals方法，以保证key唯一
 */

import java.util.HashMap;
import java.util.Set;

public class _04HashMap {
    public static void main(String[] args) {
//        show1();
        show2();
    }

    /*
        HashMap存储自定义类型键值
        Key：Person类型
            Person类就必须重写hashCode方法和equals方法，以保证Key唯一
        value：String类型
    */
    private static void show2(){
        HashMap<Person,String> map = new HashMap<>();
        map.put(new Person("Asia",18),"武汉");
        map.put(new Person("Asia2",19),"田坪");
        map.put(new Person("Asia3",17),"古塘");
        map.put(new Person("Asia4",16),"长沙");
        System.out.println(map);
        Set<Person> set = map.keySet();
        for (Person each:set){
            System.out.println(map.get(each) + " ---> " + each);
        }
    }

    /*
        HashMap存储自定义类型键值
        Key:String 类型
            String类重写hashCode方法和equals方法，可以保证key唯一
        value：Person类型
            value可以重复（同名同年龄的人视为同一个）
     */
    private static void show1(){
        HashMap<String ,Person> map = new HashMap<>();
        map.put("北京",new Person("张三",18));
        map.put("上海",new Person("李四",19));
        map.put("广州",new Person("王五",20));
        map.put("北京",new Person("赵六",18));
        System.out.println(map);
        //遍历Map
        Set<String> set = map.keySet();
        for (String each:set){
            System.out.println(each + "  --->  " + map.get(each));
        }
    }
}
