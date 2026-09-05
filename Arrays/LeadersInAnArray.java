/* Given an integer array nums, return a list of all the leaders in the array.
A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array. */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {

    // Brute Force Approach: For each element in the array, check if it is greater than all elements to its right. If it is, then add it to the leader array.
    // Time Complexity: O(n^2) where n is the length of the given array. For each element, we are checking all elements to its right.
    // Space Complexity: O(n) for storing the leader array.
    public List<Integer> leadersInAnArrayBruteForce(int[] nums) {
        // Step 1: Declare a list to store leaders
        List<Integer> leaders = new ArrayList<>();

        // Step 2: Traverse through the array
        for(int i=0; i<nums.length; i++){
            boolean isLeader = true;

            // Step 3: Check if the current element is greater than all elements to its right
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] <= nums[j]){
                    isLeader = false;
                    break;
                }
            }

            // Step 4: If it is a leader, add it to the leader array
            if(isLeader){
                leaders.add(nums[i]);
            }
        }

        return leaders;
    }

    // Optimal Approach: Traverse the array from right to left and keep track of the maximum element seen so far. If the current element is greater than the maximum element, it is a leader.
    // Time Complexity: O(n) where n is the length of the given array. We are traversing the array only once.
    // Space Complexity: O(n) for storing the leader array, but it's not counted as extra space as we are returning the leader array.
    public List<Integer> leadersInAnArrayOptimal(int[] nums) {
        // Step 1: Declare a list to store leaders
        List<Integer> leaders = new ArrayList<>();

        // Step 2: Initialize the maximum element to the last element of the array
        int max = nums[nums.length - 1];

        // Step 3: Add the last element to the leader array as it is always a leader
        leaders.add(max);

        // Step 4: Traverse the array from right to left
        for(int i=nums.length - 2; i>=0; i--){
            // Step 5: If the current element is greater than the maximum element, it is a leader
            if(nums[i] > max){
                max = nums[i];
                leaders.add(max);
            }
        }

        // Step 6: Reverse the leader array to get the elements in the order they appear in the original array
        java.util.Collections.reverse(leaders);

        return leaders;
    }

}
