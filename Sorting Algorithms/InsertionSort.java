/* Insertion Sort Algorithm */

/* Time Complexity: O(n^2), Space Complexity: O(1) */
/** Best when the array is nearly sorted, space efficient, stable, and in-place.
 *Use it when there is a continuous flow of elements to be inserted,
 *and we want to keep them sorted and maintain their relative order */

public class InsertionSort{
  public int[] insertionSort(int[] arr){
    int n = arr.length;
    for(int i=1; i<n; i++){
      int j=i;
      while(j>0 && arr[j-1] > arr[j]){
        int temp = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = temp;
        j--;
      }
    }

    return arr;
  }
}