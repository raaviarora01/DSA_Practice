/* A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory. */

package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextPermutation{

    // Brute Force Approach: Generate all permutations of the given array, sort them lexographically and find the next permutation of the given array.
    // Works only if the given array has distinct elements. If the given array has duplicate elements, then we can use a Set to store all permutations to avoid duplicates.
    // Time Complexity: O(n! * nlogn) where n is the length of the given array. O(n!) for generating all permutations and O(nlogn) for sorting them lexographically.
    // Space Complexity: O(n!) for storing all permutations in a list.
    public void nextPermutationBruteForceDistinct(int[] nums) {
        // Step 1: Declare a list to store all permutations
        List<List<Integer>> allPermutations = new ArrayList<>();

        // Step 2: Generate all permutations
        generatePermutations(0, nums, allPermutations);

        // Step 3: Sort permutations lexographically
        allPermutations.sort((a,b) -> {
            for(int i=0; i<a.size(); i++){
                int cmp = Integer.compare(a.get(i), b.get(i));
                if(cmp != 0) return cmp;
            }
            return 0;
        });

        // Step 4: Traverse throught sorted list to find the index of current permutation
        int currIndex = 0;

        for(int i=0; i<allPermutations.size(); i++){
            boolean same = true;

            for(int j=0; j<nums.length; j++){
                if(nums[j] != allPermutations.get(i).get(j)){
                    same = false;
                    break;
                }
            }

            if(same){
                currIndex = i;
                break;
            }
        }

        // Step 5: Get next permutation
        int nextIndex = (currIndex + 1) % allPermutations.size();

        // Step 6: Copy next permutation into nums
        for(int i=0; i<nums.length; i++){
            nums[i] = allPermutations.get(nextIndex).get(i);
        }
    }

    // Brute Force Approach(Uses Set) : Generate all permutations of the given array, sort them lexographically and find the next permutation of the given array.
    // Works for both distinct and duplicate elements in the given array.
    // Time Complexity: O(n! * nlogn) where n is the length of the given array. O(n!) for generating all permutations and O(nlogn) for sorting them lexographically.
    // Space Complexity: O(n!) for storing all permutations in a set.
    public void nextPermutation(int[] nums) {
        // Step 1: Declare a list to store all permutations
        Set<List<Integer>> permutations = new HashSet<>();

        // Step 2: Generate all permutations
        generatePermutations(0, nums, permutations);

        // Convert Set to List so we can sort it
        List<List<Integer>> allPermutations = new ArrayList<>(permutations);

        // Step 3: Sort permutations lexographically
        allPermutations.sort((a,b) -> {
            for(int i=0; i<a.size(); i++){
                int cmp = Integer.compare(a.get(i), b.get(i));
                if(cmp != 0) return cmp;
            }
            return 0;
        });

        // Step 4: Traverse throught sorted list to find the index of current permutation
        int currIndex = 0;

        for(int i=0; i<allPermutations.size(); i++){
            boolean same = true;

            for(int j=0; j<nums.length; j++){
                if(nums[j] != allPermutations.get(i).get(j)){
                    same = false;
                    break;
                }
            }

            if(same){
                currIndex = i;
                break;
            }
        }

        // Step 5: Get next permutation
        int nextIndex = (currIndex + 1) % allPermutations.size();

        // Step 6: Copy next permutation into nums
        for(int i=0; i<nums.length; i++){
            nums[i] = allPermutations.get(nextIndex).get(i);
        }
    }

    // Optimal Approach: Find the next permutation using the following steps:
    // 1. Traverse the array from the end and find the first element which is smaller
    // than its next element. Let's call this element as break point.
    // 2. If no such element is found, then the array is in descending order
    // and we need to reverse the array to get the next permutation.
    // 3. If such an element is found, then traverse the array from the end and find the first element which is greater than the break point.
    // 4. Swap the break point and the element found in step 3.
    // 5. Reverse the array from the break point + 1 to the end of the array.
    // Time Complexity: O(n) where n is the length of the given array.
    // Space Complexity: O(1) as we are not using any extra space.
    public void nextPermutationOptimal(int[] nums) {
        int n = nums.length;
        int break_pt = -1;

        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                break_pt = i;
                break;
            }
        }

        if(break_pt == -1){
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1; i>break_pt; i--){
            if(nums[i] > nums[break_pt]){
                swap(nums, break_pt, i);
                break;
            }
        }

        reverse(nums, break_pt+1, n-1);
    }

    /* Helper methods */
    public static void generatePermutations(int ind, int[] nums, Set<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int num : nums){
                ds.add(num);
            }
            ans.add(ds);
            return;
        }

        for(int i=ind; i<nums.length; i++){
            swap(nums, i, ind);
            generatePermutations(ind+1, nums, ans);
            swap(nums, i, ind);
        }
    }

    public static void generatePermutations(int ind, int[] nums, List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int num : nums){
                ds.add(num);
            }
            ans.add(ds);
            return;
        }

        for(int i=ind; i<nums.length; i++){
            swap(nums, i, ind);
            generatePermutations(ind+1, nums, ans);
            swap(nums, i, ind);
        }
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}