/* Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. If the target is not found in the array, return -1 */

package Arrays;

public class LinearSearch {

    /** Returns the smallest index where the target appears in the array. If the target is not found, returns -1.
     * Time Complexity: O(n) - The method iterates through the input array once.
     * Space Complexity: O(1) - The method uses a constant amount of space for variables.
     */
    public int linearSearch(int nums[], int target) {
		for(int i=0; i<nums.length; i++){
            if(nums[i] == target) return i;
        }

        return -1;
    }
}
