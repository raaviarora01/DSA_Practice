/* Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array. */

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    
    // Brute Force Approach: Iterate through the array and check all possible sub-arrays to find the ones that sum to k.
    // Time Complexity: O(n^2) - The method iterates over input array twice
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the result
    public int subarraySumBruteForceApproach(int[] nums, int k) {
        int count = 0;

        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }

    // Optimal Approach: Use HashMap to store the sum of elements from the start of the array to the current index. If the difference between the current sum and k exists in the HashMap, it means there is a sub-array that sums to k.
    // Time Complexity: O(n) - The method iterates over input array once.
    // Space Complexity: O(n) - The method uses a HashMap to store the sum of elements from the start of the array to the current index, which can take up to n space in the worst case.
    public int subarraySumOptimalApproach(int[] nums, int k) {
        int count = 0;
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

