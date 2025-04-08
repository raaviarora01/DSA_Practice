public class QuickSort {
  void quickSort(int arr[], int low, int high) {
    if (low >= high)
      return;

    int pivot = partition(arr, low, high);
    quickSort(arr, low, pivot - 1);
    quickSort(arr, pivot + 1, high);
  }

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
