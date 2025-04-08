public class SelectionSort {
  void selectionSort(int arr[]){
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
  }
}
