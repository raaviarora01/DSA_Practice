package Set;

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
    }
}
