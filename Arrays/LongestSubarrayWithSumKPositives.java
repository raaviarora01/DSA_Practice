/* Given an array nums of size n with all non-negative integers and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0. */

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumKPositives {

    // Brute Force Approach: Iterates through the array and checks all possible sub-arrays to find the longest one that sums to k.
    // Time Complexity: O(n^2) - The method iterates over input array twice
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the result
    public int longestSubarrayWithSumKBruteForceApproach(int[] nums, int k) {
        int maxLength = 0;

        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];

                if(sum == k){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }

        return maxLength;
    }

    // Better Approach: Use HashMap to store the sum of elements from the start of the array to the current index. If the difference between the current sum and k exists in the HashMap, it means there is a sub-array that sums to k.
    // Time Complexity: O(n) - The method iterates over input array once.
    // Space Complexity: O(n) - The method uses a HashMap to store the sum of elements from the start of the array to the current index, which can take up to n space in the worst case.
    public int longestSubarrayWithSumKBetterApproach(int[] nums, int k) {
        int maxLength = 0;
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum == k){
                maxLength = i + 1;
            }

            if(map.containsKey(sum - k)){
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    // Optimal Approach: Use two pointers to find the longest sub-array that sums to k. The left pointer starts at the beginning of the array and the right pointer moves to the right, adding elements to the sum. If the sum exceeds k, move the left pointer to the right until the sum is less than or equal to k.
    // Time Complexity: O(n) - The method iterates over input array once.
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the result.
    public int longestSubarrayWithSumKOptimalApproach(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int sum = 0;

        for(int right=0; right<nums.length; right++){
            sum += nums[right];

            while(sum > k && left <= right){
                sum -= nums[left];
                left++;
            }

            if(sum == k){
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
