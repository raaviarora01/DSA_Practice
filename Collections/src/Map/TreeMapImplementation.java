package Map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapImplementation {
    public static void main(String[] args) {
        TreeMap<Integer, String > map = new TreeMap<>();
        map.put(40, "D");
        map.put(10, "A");
        map.put(30, "C");
        map.put(20, "B");
        map.put(50, "E");

        //all mappings in key order
        System.out.println(map);

        //first key
        System.out.println(map.firstEntry());

        //last key
        System.out.println(map.lastEntry());

        //lower key than 30
        System.out.println(map.lowerEntry(30));

        //higher key than 30
        System.out.println(map.higherEntry(30));

        //floor key of 25
        System.out.println(map.floorEntry(25));

        //ceiling key of 25
        System.out.println(map.ceilingEntry(25));
    }
}
