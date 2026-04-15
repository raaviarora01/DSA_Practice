/* Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result. */

package Recursion;

public class Atoi {
    public int myAtoi(String s) {
        int i = 0;

        while(i < s.length() && s.charAt(i) == ' ') i++;

        int sign = 1;
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        return helper(s, i, 0, sign);
    }

    public static int helper(String s, int index, long num, int sign){
        if(index >= s.length() || !Character.isDigit(s.charAt(index))){
            return (int)(sign * num);
        }

        num = (num * 10) + (s.charAt(index) - '0');

        if(sign * num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(sign * num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return helper(s, index + 1, num, sign);
    }
}
