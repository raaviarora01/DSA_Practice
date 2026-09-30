package Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetImplementation {
    public static void main(String[] args){

        // Print each value that appears as a duplicate only once.
        int[] nums = {10, 20, 30, 10, 40, 20, 50, 10};


        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for(int num : nums){
            if(!seen.add(num)){
                duplicates.add(num);
            }
        }

        System.out.println(duplicates);

        /* Set Operations */
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 7));

        // Intersection
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection: " + intersection);

        // Union
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union: " + union);

        // Difference
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference: " + difference);
    }
}
