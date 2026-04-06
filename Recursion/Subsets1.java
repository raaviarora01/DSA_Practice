/* Given an array nums of n integers. Return array of sum of all subsets of the array nums.
Output can be returned in any order. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets1 {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        backtrack(0, nums, 0, result);
        return result;
    }

    public static void backtrack(int ind, int[] nums, int sum, List<Integer> result){
        if(ind == nums.length){
            result.add(sum);
            return;
        }

        backtrack(ind+1, nums, sum + nums[ind], result);
        backtrack(ind+1, nums, sum, result);
    }
}
