/* Selection Sort Algorithm */

/* Time Complexity: O(n^2), Space Complexity: O(1) */
/* Best when the array is small, space efficient, and in-place */

public class SelectionSort {
  public int[] selectionSort(int arr[]){
    int n = arr.length;
    for(int i=0; i<=n-2; i++){
      int min = i;
      for(int j=i+1; j<=n-1; j++){
        if(arr[j] < arr[min]){
          min = j;
        }
      }
      if(min != i){
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
      }
    }

    return arr;
  }
}
