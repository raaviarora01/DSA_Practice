/* Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array. */

package Arrays;

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
}

