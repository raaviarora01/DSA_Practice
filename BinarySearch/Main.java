public class Main {
  public static void main(String[] args) {
    int arr[] = { 3, 4, 6, 7, 9, 12, 16, 17 };
    int target = 6;
    // IterativeBinarySearch bs = new IterativeBinarySearch();
    // int ind = bs.binarySearch(arr, target);

    RecursiveBinarySearch bs = new RecursiveBinarySearch();
    int ind = bs.binarySearch(arr, 0, arr.length - 1, target);

    if (ind == -1)
      System.out.println("The target is not present.");
    else
      System.out.println("The target is at index: " + ind);
  }
}
