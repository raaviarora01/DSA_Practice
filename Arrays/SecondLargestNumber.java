/* Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1. */

package Arrays;

public class SecondLargestNumber {

    /** Returns the second-largest element in the array. If the second-largest element does not exist, returns -1.
     * Time Complexity: O(n) - The method iterates through the input array once.
     * Space Complexity: O(1) - The method uses a constant amount of space for variables.
     */
    public int secondLargestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {

            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}