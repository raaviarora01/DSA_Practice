/* Given an array nums of size n with all non-negative integers and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0. */

package Arrays;

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
}
