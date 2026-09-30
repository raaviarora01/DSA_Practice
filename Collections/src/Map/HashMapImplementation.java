package Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapImplementation {
    public static void main(String[] args) {

        // Create a frequency map
        int[] nums = {
                1, 2, 1, 3, 2, 1, 4, 2
        };
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> mergeMap = new HashMap<>();


        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            mergeMap.merge(num, 1, Integer::sum);
        }

        System.out.println("Frequency Map");
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Merge Map");
        for(Map.Entry<Integer, Integer> entry : mergeMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
