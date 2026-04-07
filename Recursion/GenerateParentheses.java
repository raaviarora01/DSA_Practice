/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    // Approach 1: Keep track of the number of left and right parentheses remaining. We can only add a left parenthesis if there are any remaining, and we can only add a right parenthesis if there are more right parentheses remaining than left parentheses (to ensure that we never have more right parentheses than left parentheses at any point).
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;
    }

    public static void generate(int left, int right, String s, List<String> result){
        if(left == 0 && right == 0){
            result.add(s);
            return;
        }

        if(left == right || left > 0){
            generate(left-1, right, s + "(", result);
        }
        if(right > left){
            generate(left, right-1, s + ")", result);
        }
    }

    // Approach 2: Keep track of the number of left and right parentheses used so far. We can only add a left parenthesis if we have used fewer than n left parentheses, and we can only add a right parenthesis if we have used fewer right parentheses than left parentheses (to ensure that we never have more right parentheses than left parentheses at any point).
    public List<String> generateParenthesisApproach2(int n) {
        List<String> result = new ArrayList<>();
        generateApproach2(0, 0, n, "", result);
        return result;
    }

    public static void generateApproach2(int left, int right, int n, String s, List<String> result){
        if(s.length() == 2*n){
            result.add(s);
            return;
        }

        if(left == right || left < n){
            generateApproach2(left+1, right, n, s + "(", result);
        }
        if(right < left){
            generateApproach2(left, right+1, n, s + ")", result);
        }
    }
}
