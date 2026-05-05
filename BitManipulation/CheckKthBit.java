/* Given two positive integer n and  k, check if the kth index bit of n is set or not.
 Note: A bit is called set if it is 1. */

package BitManipulation;

public class CheckKthBit {

    // Approach 1: Check kth bit from LSB - TC: O(1) and SC: O(1)
    public boolean checkKthBitLSB(int n, int k) {
        int res = n & (1 << k);
        if(res > 0) return true;
        return false;
    }

    // Approach 2: Check kth bit from MSB - TC: O(1) and SC: O(1)
    public char checkKthBitMSB(int n, int k) {
        if (n == 0) return '0';

        // int len = (int)(Math.log(n)/Math.log(2)) + 1;  // Method 1: Calculate the number of bits using logarithm
        // int len = Integer.toBinaryString(n).length(); // Method 2: Calculate the number of bits by converting to binary string
        int len = 32 - Integer.numberOfLeadingZeros(n); // Method 3: Calculate the number of bits using built-in function (number of leading zeros)
        if (k > len) return '0';

        int res = n & (1 << (len - k));
        return res != 0 ? '1' : '0';
    }
}
