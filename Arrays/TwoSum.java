/* You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order. */

package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Brute Force Approach: Iterates through the array and checks all possible pairs to find the two numbers that add up to target.
    // Time Complexity: O(n^2) - The method iterates over input array twice
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the result
    public int[] twoSumBruteForceApproach(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Better Approach: Uses a HashMap to store the numbers and their indices. For each number, check if the complement (target - number) exists in the HashMap. If it does, return the indices of the two numbers.
    // Time Complexity: O(n) - The method iterates over input array once.
    // Space Complexity: O(n) - The method uses a HashMap to store the numbers and their indices, which can take up to n space in the worst case.
    public int[] twoSumBetterApproach(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    // Optimal Approach: Sort the array and use two pointers to find the two numbers that add up to target. The left pointer starts at the beginning of the array and the right pointer starts at the end of the array. If the sum of the two numbers is less than target, move the left pointer to the right. If the sum is greater than target, move the right pointer to the left. If the sum is equal to target, return the indices of the two numbers.
    // Time Complexity: O(nlogn) - The method sorts the input array, which takes O(nlogn) time, and then iterates over the sorted array once.
    // Space Complexity: O(n) - The method uses a HashMap to store the numbers and their indices, which can take up to n space in the worst case.
    public int[] twoSumOptimalApproach(int[] nums, int target) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int left = 0;
        int right = sortedNums.length - 1;

        while(left < right){
            int sum = sortedNums[left] + sortedNums[right];
            if(sum == target){
                int index1 = -1;
                int index2 = -1;
                for(int i=0; i<nums.length; i++){
                    if(nums[i] == sortedNums[left] && index1 == -1){
                        index1 = i;
                    } else if(nums[i] == sortedNums[right] && index2 == -1){
                        index2 = i;
                    }
                }
                return new int[]{index1, index2};
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

}
