/* Problem Statement - Given a sorted array of nums and an integer x, write a program to find the lower bound of x. The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.
If no such index is found, return the size of the array. */

public class LowerBound{
  public int lowerBound(int[] nums, int x) {
    int low = 0; 
    int high = nums.length-1;
    int index = nums.length;

    while(low <= high){
        int mid = (low+high)/2;
        if(nums[mid] >= x){
            index=mid;
            high = mid-1;
        }
        else low = mid+1;
    }
    return index;
  }
}