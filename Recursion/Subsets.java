/* Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePowerSet(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void generatePowerSet(int ind, int[] nums, List<Integer> current, List<List<Integer>> result){
        if(ind >= nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[ind]);
        generatePowerSet(ind+1, nums, current, result);
        current.remove(current.size() - 1);
        generatePowerSet(ind+1, nums, current, result);
    }
}
