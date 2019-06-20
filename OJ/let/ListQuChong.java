package Lettcode.let;

import java.util.HashSet;
import java.util.List;

public class ListQuChong {
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
