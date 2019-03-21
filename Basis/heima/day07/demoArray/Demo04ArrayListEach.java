package heima.day07.demoArray;

import java.util.ArrayList;

public class Demo04ArrayListEach {

    public static void main(String[] args) {

        ArrayList<String > list = new ArrayList<>();
        list.add("Asia");
        list.add("Asia2");
        list.add("Asia1");

        // 遍历集合
//        for (int i = 0; i < list.size(); ++i){
//            System.out.println(list.get(i));
//        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
            

    }
}
