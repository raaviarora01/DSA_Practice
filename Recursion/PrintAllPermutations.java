/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {
    public List<List<Integer>> permute(int[] nums) {
        boolean freq[] = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backtrackApproach1(nums, freq, new ArrayList<>(), result);
        backtrackApproach2(0, nums, new ArrayList<>(), result);
        return result;
    }

    // Approach 1: Using a frequency array to keep track of which elements have been included in the current permutation, requires O(n) space for the frequency array and O(n) space for the current permutation list, resulting in O(n) space complexity.
    public static void backtrackApproach1(int[] nums, boolean freq[], List<Integer> ans, List<List<Integer>> result){
        if(ans.size() == nums.length){
            result.add(new ArrayList<>(ans));
        }

        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ans.add(nums[i]);
                backtrackApproach1(nums,  freq, ans, result);
                ans.remove(ans.size() - 1);
                freq[i] = false;
            }
        }
    }

    // Approach 2: Using swapping to generate permutations in-place, does not require additional space for a frequency array, but it modifies the input array during the backtracking process. The space complexity is O(n) due to the recursive call stack and the current permutation list.
    public static void backtrackApproach2(int ind, int[] nums, List<Integer> ans, List<List<Integer>> result){
        if(ind == nums.length){
            result.add(new ArrayList<>(ans));
        }

        for(int i=ind; i<nums.length; i++){
            swap(ind, i, nums);
            ans.add(nums[ind]);
            backtrackApproach2(ind+1, nums, ans, result);
            ans.remove(ans.size() - 1);
            swap(ind, i, nums);
        }
    }

    public static void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
