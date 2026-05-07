/* Given two integers a and b, swap them in-place using only 2 variables (without using a temporary variable). */

package BitManipulation;

public class SwapTwoNumbers {

    /**
     * Swaps two integers and returns them as an array.
     *
     * @param a the first integer
     * @param b the second integer
     * @return an array with the two integers swapped
     */
    public int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a,b};
    }
}
