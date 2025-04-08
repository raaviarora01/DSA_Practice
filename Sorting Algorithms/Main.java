class Main {
  public static void main(String[] args) {
    int arr[] = { 10, 5, 30, 15, 50, 6 };
    // int arr[] = {1,2,3,4,5};

    // BubbleSort bs = new BubbleSort();
    // bs.bubbleSort(arr);

    // SelectionSort ss = new SelectionSort();
    // ss.selectionSort(arr);

    // InsertionSort is = new InsertionSort();
    // is.insertionSort(arr);

    // MergeSort ms = new MergeSort();
    // ms.mergeSort(arr, 0, arr.length-1);

    QuickSort qs = new QuickSort();
    qs.quickSort(arr, 0, arr.length - 1);
    printArray(arr);
  }

  public static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}