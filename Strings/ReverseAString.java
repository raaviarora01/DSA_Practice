package Strings;

public class ReverseAString {

    // Brute Force approach: Build a new string by iterating the original string from the end to the beginning.
    // Time Complexity: O(n^2) due to string concatenation in a loop. Since Java string is immutable, each concatenation creates a new string, and copies the old string to the new one, leading to O(n) time for each concatenation.
    // Space Complexity: O(n) for the new string created.
    public String reverseString(String s) {
        String reversed = "";
        
        for(int i=s.length()-1; i>=0; i--){
            reversed += s.charAt(i);
        }
        
        return reversed;
    }

    // Better approach: Use StringBuilder to build the reversed string.
    // Time Complexity: O(n) since we are iterating through the string once.
    // Space Complexity: O(n) for the StringBuilder.
    public static String reverseStringBetter(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }

    // Optimal approach: Convert the string to a character array and swap characters in place.
    // Time Complexity: O(n/2) = O(n) since we are iterating through half of the string.
    // Space Complexity: O(n) for the character array.
    public static String reverseStringOptimal(String s) {
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length/2; i++){
            char temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        
        return new String(arr);
    }
}
