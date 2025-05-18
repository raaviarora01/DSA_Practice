/* You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space. */

public class SingleElementInASortedArray{
  public int singleNonDuplicate(int[] nums) {
    int n = nums.length;
    if(n == 1) return nums[0];
    if(nums[0] != nums[1]) return nums[0];
    if(nums[n-1] != nums[n-2]) return nums[n-1];

    int low = 1;
    int high = nums.length-2;

    while(low <= high){
      int mid = (low+high)/2;

      if((nums[mid] != nums[mid-1]) && (nums[mid] != nums[mid+1])) return  nums[mid];
      
      // If elements at index (even, odd) are equal, then you are in the left half of array, and the answer is on right half
      // Eliminate the left half
      if((mid%2 != 0 && nums[mid] == nums[mid-1]) || (mid%2 == 0 && nums[mid] == nums[mid+1])){
         low = mid + 1;
      }
      // Else, you are in the right half of the array, and answer is on left half
      // Eliminate the right half
      else{
        high = mid - 1;
      }
    }

    return -1;
  }
}