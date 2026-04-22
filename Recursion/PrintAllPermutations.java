/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {
    public List<List<Integer>> permute(int[] nums) {
        boolean freq[] = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, freq, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int[] nums, boolean freq[], List<Integer> ans, List<List<Integer>> result){
        if(ans.size() == nums.length){
            result.add(new ArrayList<>(ans));
        }

        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ans.add(nums[i]);
                backtrack(nums,  freq, ans, result);
                ans.remove(ans.size() - 1);
                freq[i] = false;
            }
        }
    }
}
