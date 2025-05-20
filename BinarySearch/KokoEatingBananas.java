/* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours. */
public class KokoEatingBananas {
    public static int minEatingSpeed(int arr[], int h) {
        int low = 1;
        int high = maxInArray(arr);

        while (low <= high) {
            int mid = (low + high) / 2;
            if (calculateTotalHours(arr, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int calculateTotalHours(int[] arr, int mid) {
        int totalH = 0;

        for (int i = 0; i < arr.length; i++) {
            totalH += Math.ceil((double) arr[i] / (double) mid);
        }

        return totalH;
    }

    private static int maxInArray(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }
}
