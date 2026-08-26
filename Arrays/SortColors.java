/* You are given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 
You must solve this problem without using the library's sort function. */

package Arrays;

public class SortColors {

    // Brute Force approach: Count the number of 0s, 1s, and 2s, and then overwrite the original array with the counted values.
    // Time Complexity: O(n), Space Complexity: O(1)
    public void sortColorsBruteForce(int[] nums) {
        int count0=0, count1=0, count2=0;
 
        for(int num : nums){
            if(num == 0) count0++;
            else if(num == 1) count1++;
            else count2++;
        }
 
        int index = 0;
        while(count0-- > 0){
            nums[index++] = 0;
        }
 
        while(count1-- > 0){
            nums[index++] = 1;
        }
 
        while(count2-- > 0){
            nums[index++] = 2;
        }
    }
 
    //Optimal approach: Dutch National Flag Algorithm
    // Time Complexity: O(n), Space Complexity: O(1)
    // Optimal because it only requires a single pass through the array and uses constant space.
    public void sortColorsOptimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
 
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                mid++;
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
 
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
