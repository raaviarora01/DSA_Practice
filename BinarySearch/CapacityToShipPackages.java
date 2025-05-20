/* A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days. */
public class CapacityToShipPackages {
    public static int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < weights.length; i++) {
            low = Math.max(weights[i], low);
            high += weights[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (findDays(weights, mid) <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    private static int findDays(int[] arr, int capacity) {
        int noOfDays = 1;
        int wt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (wt + arr[i] > capacity) {
                noOfDays++;
                wt = arr[i];
            } else {
                wt += arr[i];
            }
        }

        return noOfDays;
    }
}
