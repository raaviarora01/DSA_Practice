/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
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
}
