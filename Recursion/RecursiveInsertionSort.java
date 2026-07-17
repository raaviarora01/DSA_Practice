/* Recursive Insertion Sort Algorithm */

package Recursion;

public class RecursiveInsertionSort {

    /* Time Complexity: O(n^2), Space Complexity: O(n) - recursion stack */
    public static void recursiveInsertionSort(int[] nums, int i){
        if(i == nums.length) return;

        int j = i;
        while(j>0 && nums[j-1] > nums[j]){
            int temp = nums[j];
            nums[j] = nums[j-1];
            nums[j-1] = temp;
            j--;
        }

        recursiveInsertionSort(nums, i+1);
    }

}
