package Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapImplementation {
    public static void main(String[] args) {
        // Find first non-repeating character
        String str = "swiss";

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println("First non-repeating character: " + entry.getKey());
                break;
            }
        }
    }
}
