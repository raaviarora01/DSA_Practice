/* You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1. */
public class MinDaysToMakeMBouquets {
    public static int minDays(int arr[], int m, int k) {
        if (m * k > arr.length)
            return -1;
        int low = findMin(arr);
        int high = findMax(arr);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (possible(arr, mid, m, k))
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    private static boolean possible(int[] arr, int mid, int m, int k) {
        int c = 0;
        int numOfB = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= mid)
                c++;
            else {
                numOfB += (c / k);
                c = 0;
            }
        }
        numOfB += (c / k);
        return numOfB >= m;
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    private static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        return min;
    }
}
