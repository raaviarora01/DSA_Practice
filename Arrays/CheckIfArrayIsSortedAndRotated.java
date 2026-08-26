/* Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i. */

package Arrays;

public class CheckIfArrayIsSortedAndRotated{

    /* Checks for inversion points. If there is more than one inversion point, the array is not sorted and rotated.
    * Also checks if the first element is less than the last element, which indicates that the array is not rotated.
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    */
    public static boolean check(int[] nums) {
        int n = nums.length;
        if(n == 1) return true; 
        int inversion_pt = 0;
        for(int i=1; i<n; i++){
            if(nums[i] < nums[i-1]) inversion_pt++;
            if(inversion_pt > 1) return false;
        }

        if(nums[0] < nums[n-1]) inversion_pt++;
        return inversion_pt<=1;
    }
}