/* Given a binary array nums, return the maximum number of consecutive 1's in the array. */

package Arrays;

public class MaxConsecutiveOnes {

    // Time Complexity: O(n) - The method iterates over input array once
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the count and max values
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for(int num : nums){
            if(num == 1){
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);

        return max;
    }
}
