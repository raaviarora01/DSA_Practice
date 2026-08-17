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

    // Better Approach(Only Applicaple if the array contains only 0 or positive integers): Uses a Hash Array to count the occurrences of each number and finds the single number.
    // Time Complexity: O(n + max) - The method iterates over input array twice and over hash array once which is of length max
    // Space Complexity: O(max) - The method uses a hash array to store the occurrences of each number, which takes max length space in the best and worst case.
    public int singleNumberHashArrayApproach(int[] nums) {
        int max = nums[0];
        for(int num : nums){
            if(num > max) max = num;
        }

        int[] hashArr = new int[max+1];

        for(int num : nums){
            hashArr[num] += 1;
        }

        for(int i=0; i<hashArr.length; i++){
            if(hashArr[i] == 1) return i;
        }

        return -1;
    }


    // Optimal Approach: Uses xor to find the single element
    // Time Complexity: O(n) - The method iterates over input array once to find the single number.
    // Space Complexity: O(1) - The method uses a constant amount of space for variable to store the result
    public int singleNumberOptimalApproach(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor = xor ^ num;
        }

        return xor;
    }
}
