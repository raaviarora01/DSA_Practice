/* Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1. */

package Strings;

import java.util.HashMap;
import java.util.Map;

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

    // Optimal Approach: Use a HashMap to store the frequency of each character, then iterate through the string to find the first character with a frequency of 1.
    // Time Complexity: O(n) since we are iterating through the string twice.
    // Space Complexity: O(k) where k is the number of unique characters in the string.
    public int firstUniqCharOptimal(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }

        return -1;
    }

    // Optimal Approach 2: Use this only for fixed character set (like lowercase English letters). Use an array to store the frequency of each character, then iterate through the string to find the first character with a frequency of 1.
    // Time Complexity: O(n) since we are iterating through the string twice.
    // Space Complexity: O(1) since we are using a fixed size array of 26 for lowercase English letters.
    public int firstUniqCharOptimalApproach2(String s) {
        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(freq[ch - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}
