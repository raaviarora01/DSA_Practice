/* Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order. */

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int ind, int[] nums, List<Integer> list, List<List<Integer>> result){
        result.add(new ArrayList<>(list));

        for(int i=ind; i<nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backtrack(i+1, nums, list, result);
            list.remove(list.size() - 1);
        }
    }
}
