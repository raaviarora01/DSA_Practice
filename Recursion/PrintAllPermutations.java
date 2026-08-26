/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {

    // Brute Force approach: Use a frequency array to keep track of the elements that have been used in the current permutation. When the current permutation is complete, add it to the result list.
    // Time Complexity: O(n*n!) - There are n! permutations and it takes O(n) time to copy each permutation to the result list.
    // Space Complexity: O(n+n) - The frequency array takes O(n) space, and the recursion stack takes O(n) space.
    public List<List<Integer>> permuteApproach1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        printPermutations(nums, new ArrayList<>(), result, new boolean[nums.length]);
 
        return result;
    }
 
 
    public static void printPermutations(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
 
        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                printPermutations(nums, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
 
    // Optimal approach: Use swapping to generate permutations. Swap the current element with the element at the current index, and recursively generate permutations for the next index. After returning from the recursive call, swap back to restore the original array.
    // Time Complexity: O(n*n!) - There are n! permutations and it takes O(n) time to copy each permutation to the result list.
    // Space Complexity: O(n) - The recursion stack takes O(n) space.
    public List<List<Integer>> permuteApproach2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        printPermutations(0, nums, result);
 
        return result;
    }
 
    public static void printPermutations(int ind, int[] nums, List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int num : nums){
                ds.add(num);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
 
        for(int i=ind; i<nums.length; i++){
            swap(nums, ind, i);
            printPermutations(ind+1, nums, ans);
            swap(nums, ind, i);
        }
    }
 
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
