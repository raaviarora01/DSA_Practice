package Java8Concepts;

import java.util.*;

public class MapOperations {
    public static void main(String[] args) {

        String[][] data = {
                {"Java", "Raavi"},
                {"Python", "Aman"},
                {"Java", "Neha"},
                {"C++", "Karan"},
                {"Java", "Riya"},
                {"Python", "Amit"}
        };

        // computeIfAbsent
        Map<String, List<String>> map = new LinkedHashMap<>();

        for(String[] entry : data){
            String tech = entry[0];
            String employee = entry[1];
            map.computeIfAbsent(tech, key ->  new ArrayList<>()).add(employee);
        }

        System.out.println(map);

        // merge
        Map<String, Integer> frequencies = new HashMap<>();

        List<String> techData = new ArrayList<>(Arrays.asList("Java", "Spring", "Java", "Docker", "Spring", "Java"));

        for(String tech : techData){
            frequencies.merge(tech, 1, Integer::sum);
        }

        System.out.println(frequencies);
    }
}
