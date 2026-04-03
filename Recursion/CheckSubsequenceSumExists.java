/* Given an array nums and an integer k. R﻿eturn true if there exist subsequences such that the sum of all elements in subsequences is equal to k else false. */

package Recursion;

public class CheckSubsequenceSumExists {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return backtrack(0, nums, k, 0);
    }

    public static boolean backtrack(int ind, int[] nums, int k, int sum){
        if(sum > k) return false;
        
        if(ind == nums.length){
            return sum == k;
        }

        if(backtrack(ind + 1, nums, k, sum + nums[ind])) return true;
        
        return backtrack(ind + 1, nums, k, sum);
    }
}
