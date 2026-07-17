/* Quick Sort Algorithm */

public class QuickSort {
  /** Sorts the array using the quick sort algorithm */
  /* Time Complexity: O(n log n) best and average, O(n^2) worst case, Space Complexity: O(log n) - recursion stack */
  /* Use when we need a fast, in-place sorting algorithm and space is a concern, but it is not stable */
  public void quickSort(int arr[], int low, int high) {
    if (low >= high)
      return;

    int pivot = partition(arr, low, high);
    quickSort(arr, low, pivot - 1);
    quickSort(arr, pivot + 1, high);
  }

  /** Partitions the array around a pivot element and returns the index of the pivot */
  /* Time Complexity: O(n), Space Complexity: O(1) */
  private int partition(int[] arr, int low, int high) {
    int pivot = low;
    int i = low;
    int j = high;

    while (i < j) {
      while (arr[i] <= arr[pivot] && i < high) {
        i++;
      }
      while (arr[j] > arr[pivot] && j > low) {
        j--;
      }

      if (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[pivot];
    arr[pivot] = arr[j];
    arr[j] = temp;

    return j;
  }

}
