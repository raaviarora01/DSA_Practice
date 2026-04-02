/* Given an array nums and an integer k.Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to target. */

package Recursion;

public class CountSubsequencesWithTargetSum {

    /* Approach 1: Using 2 vairables - include and exclude to store result of recursive calls */
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return backtrack(0, nums, k, 0);
    }

    public static int backtrack(int ind, int[] nums, int target, int sum){
        if(ind == nums.length){
            return sum == target ? 1 : 0;
        }
        
        int include = backtrack(ind+1, nums, target, sum + nums[ind]);
        int exclude = backtrack(ind+1, nums, target, sum);
        return include + exclude;
    }

    /* Approach 2: Using a reference variable to keep track of the count */
    public int countSubsequenceWithTargetSumApproach2(int[] nums, int target) {
        int count[] = new int[1];
        backtrack(0, nums, target, 0, count);
        return count[0];
    }

    public static void backtrack(int ind, int[] nums, int target, int sum, int count[]){
        if(ind == nums.length){
            if(sum == target) count[0]++;
            return;
        }
        
        backtrack(ind+1, nums, target, sum + nums[ind], count);
        backtrack(ind+1, nums, target, sum, count);
    }
}
