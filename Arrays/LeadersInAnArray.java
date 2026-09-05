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

        // Step 5: Convert the list of leaders to an array and return it
        return leaders;
    }
}
