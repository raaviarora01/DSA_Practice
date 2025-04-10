/* Given a sorted array of nums consisting of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. */

public class SearchInsertPosition{
  public int searchInsert(int[] nums, int target) {
    int low = 0;
    int high = nums.length-1;
    int mid=0;

    while(low <= high){
        mid = (low+high)/2;

        if(nums[mid] == target) return mid;
        else if(target > nums[mid]) low = mid+1;
        else high = mid-1;
    }

    if(target < nums[mid]) return mid;
    return mid + 1;
  }
}