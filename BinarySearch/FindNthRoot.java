/* Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, return -1. */
public class FindNthRoot {
    public static int nthRoot(int m, int n) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            int val = power(mid, n, m);

            if (val == 1)
                return mid;
            else if (val == 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static int power(int num, int n, int m) {
        long ans = 1;

        for (int i = 0; i < n; i++) {
            ans *= num;
            if (ans > m)
                return 2;
        }

        if (ans == m)
            return 1;
        return 0;
    }
}
