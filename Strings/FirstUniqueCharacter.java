/* Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1. */

package Strings;

public class FirstUniqueCharacter {

    // Brute Force Approach: Iterate through each character and check if it appears elsewhere in the string.
    // Time Complexity: O(n^2) due to nested loops.
    // Space Complexity: O(1) since we are not using any extra space.
    public int firstUniqChar(String s) {
    
        for(int i=0; i<s.length(); i++){
            boolean found = true;
            for(int j=0; j<s.length(); j++){
                if(i != j && (s.charAt(i) == s.charAt(j))){
                    found = false;
                    break;
                }
            }
            if(found) return i;
        }

        return -1;
    }
}
