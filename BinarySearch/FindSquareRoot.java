/* Given a positive integer n. Find and return its square root. If n is not a perfect square, then return the floor value of sqrt(n). */
public class FindSquareRoot {
    public int floorSqrt(int n) {
        int low = 1, high = n;

        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;

            if (val <= (long) n)
                low = (int) mid + 1;
            else
                high = (int) mid - 1;
        }

        return high;
    }
}