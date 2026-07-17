/* Merge Sort Algorithm */

import java.util.ArrayList;

public class MergeSort {
  /** Sorts the array using the merge sort algorithm */
  /* Time Complexity: O(n log n), Space Complexity: O(n) + recursion stack (O(log n)) */
  /* Use when we need a stable, efficient sorting algorithm and space is not a constraint */
  public void mergeSort(int arr[], int low, int high){
    if(low >= high) return;
    int mid = (low + high)/2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid+1, high);
    merge(arr, low, mid, high);
  }

  /** Merges two sorted subarrays into a single sorted array */
  /* Time Complexity: O(n), Space Complexity: O(n) */
  public static void merge(int arr[], int low, int mid, int high){
    ArrayList<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid+1;
    while(left <= mid && right <= high){
      if(arr[left] <= arr[right]){
        temp.add(arr[left]);
        left++;
      }
      else{
        temp.add(arr[right]);
        right++;
      }
    }

    while(left <= mid){
      temp.add(arr[left]);
      left++;
    }

    while(right <= high){
      temp.add(arr[right]);
      right++;
    }

    for(int i=low; i<=high; i++){
      arr[i] = temp.get(i-low);
    }
  }
}
