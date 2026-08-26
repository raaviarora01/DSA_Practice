/* Given an array nums of n integers, return true if the array nums is sorted in non-decreasing order or else false. */
package Arrays;

public class ArraySorted {

    /** Returns true if the array nums is sorted in non-decreasing order, otherwise returns false.
     * Time Complexity: O(n) - The method iterates through the input array once.
     * Space Complexity: O(1) - The method uses a constant amount of space for variables.
     */
    public boolean isArraySorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}