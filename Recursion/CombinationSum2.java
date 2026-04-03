/* Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations. */

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int ind, int[] nums, int target, List<Integer> list, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind; i<nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
            list.add(nums[i]);
            backtrack(i + 1, nums, target - nums[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
