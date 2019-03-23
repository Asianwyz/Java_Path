package heima.day07.demoArray.practice;

/*
数值添加到集合
生成6个1~33之间的随机整数,添加到集合,并遍历
 */

import java.util.ArrayList;
import java.util.Random;

public class P01ArrayListRandom {

    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 6; ++i){
            int number = random.nextInt(33) + 1;
            list.add(number);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
