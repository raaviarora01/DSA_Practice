/* Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer. */
public class FindSmallestDivisor {
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = findMax(nums);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (possible(nums, mid, threshold))
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    private static boolean possible(int[] arr, int div, int threshold) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i] / (double) div);
        }

        return sum <= threshold;
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }
}
