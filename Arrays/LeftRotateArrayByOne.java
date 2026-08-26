/* Given an integer array nums, rotate the array to the left by one. */

package Arrays;

public class LeftRotateArrayByOne {

    /** Rotates the given array to the left by one position.
     * Time Complexity: O(n) - The method iterates through the input array once.
     * Space Complexity: O(1) - The method uses a constant amount of space for variables.
     */
    public void leftRotateByOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int firstElement = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = firstElement;
    }
}