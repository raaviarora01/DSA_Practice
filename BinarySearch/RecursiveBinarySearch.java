public class RecursiveBinarySearch {
  public int binarySearch(int[] arr, int low, int high, int k) {
    if (low > high)
      return -1;

    int mid = (low + high) / 2;
    if (arr[mid] == k)
      return mid;
    else if (k > arr[mid])
      return binarySearch(arr, mid + 1, high, k);
    return binarySearch(arr, low, mid - 1, k);
  }
}
