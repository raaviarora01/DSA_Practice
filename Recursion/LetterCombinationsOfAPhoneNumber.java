/* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private static String[] map;

    public LetterCombinationsOfAPhoneNumber(){
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;

        helper(0, digits, "", result);

        return result;
    }

    public void helper(int ind, String digits, String ans, List<String> result){
        if(ind == digits.length()){
            result.add(ans);
            return;
        }

        String s = map[digits.charAt(ind) - '0'];

        for(int i=0; i<s.length(); i++){
            helper(ind+1, digits, ans + s.charAt(i), result);
        }

    }
}
