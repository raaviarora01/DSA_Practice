/* Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1. */

public class FloorAndCeil{
  public void getFloorAndCeil(int[] nums, int x) {
    int floor = getFloor(nums, x, 0, nums.length-1);
    int ceil = getCeil(nums, x, 0, nums.length-1);
    System.out.println("Floor : " + floor + " | Ceil : " + ceil);
  }

  private int getFloor(int[] nums, int x, int low, int high) {
    int floor = -1;
    while(low <= high){
      int mid = (low+high)/2;

      if(nums[mid] <= x){
          floor = nums[mid];
          low = mid+1;
      }
      else high = mid-1;
    }

    return floor;
  }

  private int getCeil(int[] nums, int x, int low, int high) {
    int ceil = -1;
    while(low <= high){
      int mid = (low+high)/2;

      if(nums[mid] >= x){
          ceil = nums[mid];
          high = mid-1;
      }
      else low = mid+1;
    }

    return ceil;
  }
}