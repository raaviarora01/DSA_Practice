/* Bubble Sort Algorithm */

/* Time Complexity: O(n^2), Space Complexity: O(1) */
/* Best when the array is nearly sorted, space efficient, and in-place */
public class BubbleSort {
  public int[] bubbleSort(int arr[]){
    int n = arr.length;
    for(int i=0; i<n-1; i++){
      boolean swapped = false;
      for(int j=0; j<n-i-1; j++){
        if(arr[j] > arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          swapped = true;
        }
      }
      if (!swapped) break;
    }

    return arr;
  }
}
