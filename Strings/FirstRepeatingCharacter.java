/* Given a string s consisting of lowercase English letters, return the first letter to appear more than once in a string. */

package Strings;

public class FirstRepeatingCharacter {

    // Brute Force Approach: Iterate through each character and check if it appears elsewhere in the string.
    // Time Complexity: O(n^2) due to nested loops.
    // Space Complexity: O(1) since we are not using any extra space.
    public char repeatedCharacter(String s) {
        
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    return s.charAt(i);
                }
            }
        }

        return '\0';
    }
}
