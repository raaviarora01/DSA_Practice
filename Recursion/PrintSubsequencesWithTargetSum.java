/* Given an array nums and an integer k. Print all the non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to target. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequencesWithTargetSum {
    public void printSubsequenceWithTargetSum(int[] nums, int target) {
        backtrack(0, nums, target, 0, new ArrayList<>());
    }

    public static void backtrack(int ind, int[] nums, int target, int sum, List<Integer> current){
        if(ind == nums.length){
            if(sum == target){
                System.out.println(current);
            }
            return;
        }
        
        current.add(nums[ind]);
        backtrack(ind+1, nums, target, sum + nums[ind], current);
        current.remove(current.size() - 1);
        backtrack(ind+1, nums, target, sum, current);
    }
}
