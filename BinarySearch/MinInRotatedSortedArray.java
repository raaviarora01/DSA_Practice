/* Given the sorted rotated array nums of unique elements, return the minimum element of this array. */
public class MinInRotatedSortedArray{
  public int findMin(int[] arr) {
    int min = Integer.MAX_VALUE;
    int low = 0;
    int high = arr.length-1;

    while(low <= high){
      int mid  = (low+high)/2;

      if(arr[low] <= arr[high]){
        min = Math.min(arr[low], min);
        break;
      }

      if(arr[low] <= arr[mid]){
        min = Math.min(arr[low], min);
        low = mid+1;
      }
      else{
        min = Math.min(arr[mid], min);
        high = mid-1;
      }
    }
    return min;
  }
}