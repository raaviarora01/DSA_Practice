/* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array. */

package Arrays;

public class MoveZeroesToTheEnd {

    /** Moves all 0's to the end of the array while maintaining the relative order of the non-zero elements.
     * Time Complexity: O(n) - The method iterates through the input array twice.
     * Space Complexity: O(1) - The method uses a constant amount of space for variables.
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        for(int j=index; j<nums.length; j++){
            nums[j] = 0;
        }
    }
}
