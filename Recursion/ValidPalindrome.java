/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
 */

package Recursion;

public class ValidPalindrome {

    /* Iterative Solution 1 : Time Complexity: O(n), Space Complexity: O(1) */
    public boolean isPalindromeIterativeSolution1(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            }
            else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else{
                if (leftChar != rightChar) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }

    /* Iterative Solution 2 : Time Complexity: O(n), Space Complexity: O(1) */
    public boolean isPalindromeIterativeSolution2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){ return false;}
            left++;
            right--;
        }

        return true;
    }

    /* Iterative Solution 3 : Time Complexity: O(n), Space Complexity: O(n) */
    public boolean isPalindromeIterativeSolution3(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;
        while(left < right){
            if(cleaned.charAt(left) != cleaned.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /* Recursive Solution : Time Complexity: O(n), Space Complexity: O(n) */
    public boolean isPalindromeRecursive(String s) {
        return checkPalindromeHelper(0, s.length() - 1, s);
    }

    private boolean checkPalindromeHelper(int left, int right, String s) {
        if(left >= right) return true;

        if(!Character.isLetterOrDigit(s.charAt(left))){
            return checkPalindromeHelper(left+1, right, s);
        }
        if(!Character.isLetterOrDigit(s.charAt(right))){
            return checkPalindromeHelper(left, right-1, s);
        }

        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

        return checkPalindromeHelper(left+1, right-1, s);
    }
}
