/* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1]. */

public class FirstAndLastPosition{
  public int[] searchRange(int[] nums, int target) {
    if(nums.length == 0) return new int[]{-1,-1};
    int first = firstOccurence(nums, target, 0, nums.length-1);
    if(first == -1) return new int[]{-1,-1};
    int last = lastOccurence(nums, target, 0, nums.length-1);
    return new int[]{first, last};
  }

  public static int firstOccurence(int[] nums, int target, int low, int high){
    int first = -1;
    while(low <= high){
        int mid = (low+high)/2;
        if(nums[mid] == target){
            first = mid;
            high = mid-1;
        }
        else if(target > nums[mid]) low = mid+1;
        else high = mid-1;
    }
    return first;
}

public static int lastOccurence(int[] nums, int target, int low, int high){
    int last = -1;
    while(low <= high){
        int mid = (low+high)/2;
        if(nums[mid] == target){
            last = mid;
            low = mid+1;
        }
        else if(target > nums[mid]) low = mid+1;
        else high = mid-1;
    }
    return last;
  }
}