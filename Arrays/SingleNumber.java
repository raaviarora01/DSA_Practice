/* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space. */

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    // Brute Force Approach: Iterates through the array and counts the occurrences of each number to find the single number.
    // Time Complexity: O(n^2) - The method iterates over input array twice
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the result
    public int singleNumberBruteForceApproach(int[] nums) {
        for(int num : nums){
            int count = 0;
            for(int num2 : nums){
                if(num == num2) count++;
            }

            if(count == 1) return num;
        }
        return -1;
    }

    // Better Approach: Uses a HashMap to count the occurrences of each number and finds the single number.
    // Time Complexity: O(n) - The method iterates over input array once to populate the HashMap and once to find the single number.
    // Space Complexity: O(n) - The method uses a HashMap to store the occurrences of each number, which can take up to n space in the worst case.
    public int singleNumberBetterApproach(int[] nums) {
        Map<Integer, Integer> map =  new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }

        return -1;
    }
}
