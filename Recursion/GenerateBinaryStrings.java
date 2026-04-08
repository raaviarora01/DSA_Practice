/* Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.
A binary string is a string consisting only of characters '0' and '1'. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    public List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generate(n, "", result);
        return result;
    }

    public static void generate(int n, String s, List<String> result){
        if(s.length() == n){
            result.add(s);
            return;
        }

        generate(n, s + "0", result);

        if(s.isEmpty() || s.charAt(s.length() - 1) != '1'){
            generate(n, s + "1", result);
        }
    }
}
