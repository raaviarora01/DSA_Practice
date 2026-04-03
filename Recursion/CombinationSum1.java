/* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int ind, int[] nums, int target, List<Integer> list, List<List<Integer>> result){
        if(ind == nums.length){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if(nums[ind] <= target){
            list.add(nums[ind]);
            backtrack(ind, nums, target - nums[ind], list, result);
            list.remove(list.size() - 1);
        }
        backtrack(ind + 1, nums, target, list, result);
    }
}
