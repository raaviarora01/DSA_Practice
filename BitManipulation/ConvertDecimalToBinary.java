/* Given a decimal number n, return its binary equivalent.
Input : 12
Output : "1100"

Both approached have O(log n) time complexity and O(log n) space complexity.
However, bit manipulation is slightly more efficient in practice because it avoids costly division and modulo operations, using faster bitwise operations instead.
*/

package BitManipulation;

public class ConvertDecimalToBinary {

    // Approach 1: Using arithematic operators - TC: O(log n) and SC: O(log n)
    static String decToBinary(int n) {
        if(n == 0) return "0";
        StringBuilder res = new StringBuilder();
        while (n > 0){
            res.append(n % 2);
            n = n/2;
        }
        
        return res.reverse().toString();
    }

    // Approach 2: Using bit manipulation - TC: O(log n) and SC: O(log n)
    static String decToBinaryBitManipulation(int n) {
        if(n == 0) return "0";
        StringBuilder res = new StringBuilder();
        while (n > 0){
            res.append((n & 1));
            n = n >> 1;
        }
        
        return res.reverse().toString();
    }
}
