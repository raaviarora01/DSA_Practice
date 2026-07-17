/* Recursive Bubble Sort Algorithm */

package Recursion;

class RecursiveBubbleSort {

    /* Approach 1: Partial Recursion */
    /* Time Complexity: O(n^2), Space Complexity: O(n) - recursion stack */
    /* Best when the array is nearly sorted, space efficient, and in-place */
    public void recursiveBubbleSort(int arr[], int n) {
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        recursiveBubbleSort(arr, n - 1);
    }

    /* Approach 2: Full Recursion */
    /* Time Complexity: O(n^2), Space Complexity: O(n) - recursion stack */
    /* Best when the array is nearly sorted, space efficient, and in-place */
    public void recursiveBubbleSortFull(int arr[], int n) {
        if (n == 1) {
            return;
        }
        
        recursivePass(arr, 0, n);
        recursiveBubbleSortFull(arr, n - 1);
    }

    public static void recursivePass(int arr[], int index, int n) {
        if (index == n - 1) {
            return;
        }

        if (arr[index] > arr[index + 1]) {
            int temp = arr[index];
            arr[index] = arr[index + 1];
            arr[index + 1] = temp;
        }

        recursivePass(arr, index + 1, n);
    }
}