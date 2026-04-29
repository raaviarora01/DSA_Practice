/* Given a binary string, return its decimal equivalent.
Input : "1100"
Output : 12
*/

package BitManipulation;

public class ConvertBinaryToDecimal {

    // Approach 1: Using arithematic operators - TC: O(n) and SC: O(1)
    public int binaryToDecimal(String b) {
        int res = 0;
        int power = 0;
        
        for(int i = b.length()-1; i >= 0; i--){
            if(b.charAt(i) == '1'){
                res += Math.pow(2, power);
            }
            power++;
        }
        
        return res;
    }

    // Approach 2: Using bit manipulation - TC: O(n) and SC: O(1)
    public int binaryToDecimalBitManipulation(String b) {
        int res = 0;
        
        for(int i = 0; i < b.length(); i++){
            res = res << 1; // Left shift res by 1 bit (equivalent to multiplying res by 2)
            if(b.charAt(i) == '1'){
                res = res | 1; // Set the least significant bit (LSB) of res to 1
            }
        }
        
        return res;
    }
}
