/* Given an integer array nums, find the subarray with the largest sum, and return its sum. */

package Arrays;

public class MaximumSubarraySumKadanesAlgo {
    // Brute Force approach: Check all possible subarrays and return the one with the largest sum.
    // Time Complexity: O(n^3), Space Complexity: O(1)
    public int maxSubArrayBruteForceApproach(int[] nums) {
        int max = Integer.MIN_VALUE;
 
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += nums[k];
                }
 
                max = Math.max(sum, max);
            }
        }
 
        return max;
    }
 
    // Better approach: Check all possible subarrays and return the one with the largest sum.
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public int maxSubArrayBetter(int[] nums) {
        int max = Integer.MIN_VALUE;
 
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
 
        return max;
    }
 
    // Optimal approach: Kadane's Algorithm. Use a variable to keep track of the current subarray sum and update the maximum sum accordingly.
    // Time Complexity: O(n), Space Complexity: O(1)
    public int maxSubArrayOptimal(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
 
            max = Math.max(max, sum);
 
            if(sum < 0) sum = 0;
        }
 
        return max;
    }
}
