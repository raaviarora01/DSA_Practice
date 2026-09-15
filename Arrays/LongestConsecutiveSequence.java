/* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time. */

package Arrays;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    // Brute Force Approach: For each element in the array, check if it is the start of a sequence. If it is, then count the length of the sequence.
    // Time Complexity: O(n^2) where n is the length of the given array. For each element, we are checking all elements to find the next consecutive element.
    // Space Complexity: O(1) as we are not using any extra space.
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int longest = 1;

        for(int i=0; i<n; i++){
            int x = nums[i];
            int count = 1;
            while(linearSearch(x+1, nums)){
                count++;
                x++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static boolean linearSearch(int num, int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == num) return true;
        }

        return false;
    }

    // Better Approach : Sort the array and then find the longest consecutive sequence.
    // Time Complexity: O(nlogn) where n is the length of the given array, as we are sorting the array first and then traversing it once.
    // Space Complexity: O(1) as we are not using any extra space.
    public int longestConsecutiveBetter(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int lastSmaller = nums[0];
        int cnt = 1;
        int longest = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == lastSmaller + 1){
                cnt++;
                lastSmaller = nums[i];
                longest = Math.max(cnt, longest);
            } else if(nums[i] > lastSmaller + 1){
                cnt = 1;
                lastSmaller = nums[i];
            }
        }

        return longest;
    }
}
