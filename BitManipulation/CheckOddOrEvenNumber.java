/* Given a non-negative integer n, determine whether it is odd.
Return true if the number is odd, otherwise return false.

A number is odd if it is not divisible by 2 (i.e., n % 2 != 0). */

package BitManipulation;

public class CheckOddOrEvenNumber {
    public boolean isOdd(int n) {
        return (n & 1) != 0;
    }
}
