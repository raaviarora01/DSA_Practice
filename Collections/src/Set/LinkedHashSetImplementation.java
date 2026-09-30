package Set;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LinkedHashSetImplementation {
    public static void main(String[] args) {
        // Remove duplicates while preserving order
        List<String> technologies = Arrays.asList(
                "Java",
                "Spring",
                "Java",
                "Docker",
                "Spring",
                "AWS"
        );

        Set<String> set = new LinkedHashSet<>();

        for(String tech : technologies){
            set.add(tech);
        }

        System.out.println(set);
    }
}
