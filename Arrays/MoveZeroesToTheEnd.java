/* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array. */

package Arrays;

public class MoveZeroesToTheEnd {

    /** Approach 1: Moves all 0's to the end of the array while maintaining the relative order of the non-zero elements.
     * Places all non-zero elements at the beginning of the array and fills the remaining positions with 0's. Iterater the array twice, first to place non-zero elements and second to fill the rest with 0's.
     * Time Complexity: O(n) - The method iterates through the input array twice.
     * Space Complexity: O(1) - The method uses a constant amount of space for variables.
     */
    public void moveZeroesApproach1(int[] nums) {
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

    // Approach 2: Uses two pointers to move zeros to the end of the array. Use swapping to move non-zero elements to the front and zeros to the end. Iterate through the array once, swapping non-zero elements with the first zero found.
    // Time Complexity: O(n) - The method iterates through the input array once.
    // Space Complexity: O(1) - The method uses a constant amount of space for variables.
    public void moveZeroesApproach2(int[] nums) {
        if(nums.length <= 1) return;

        int j = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }

        if(j == -1) return;

        for(int i=j+1; i<nums.length; i++){
            if(nums[i] != 0){
                int temp =nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
