/* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise. */

package Strings;

public class CheckPalindrome {
    // Brute Force Approach: Clean the string and store it in a variable, reverse it and store in another variable, then compare the reversed and the cleaned string.
    // Time Complexity: O(n^2) due to string concatenation in a loop. Since Java string is immutable, each concatenation creates a new string, and copies the old string to the new one, leading to O(n) time for each concatenation.
    // Space Complexity: O(n) for the cleaned and reversed strings created.
    public boolean isPalindrome(String s) {

        String cleaned = "";

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                cleaned += Character.toLowerCase(c);
            }
        }

        String reversed = "";
        for(int i=cleaned.length()-1; i>=0; i--){
            reversed += cleaned.charAt(i);
        }

        return reversed.equals(cleaned);
    }
}
