/* Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), return the only number missing from the array within this range. */

package Arrays;

public class FindMissingNumber {

    // Brute Force Approach: Calculates the expected sum of numbers from 0 to n and subtracts the actual sum of the array to find the missing number.
    // Time Complexity: O(n) - The method iterates through the input array once to calculate the actual sum.
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the expected and actual sums.
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // Optimal Approach: Uses the XOR operation to find the missing number by leveraging the properties of XOR.
    // Time Complexity: O(n) - The method iterates through the input array once to compute the XOR of all numbers.
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the XOR results.
    public int missingNumberXOR(int[] nums) {
        int n = nums.length;
        int xorAll = 0;
        int xorArray = 0;

        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }

        for (int num : nums) {
            xorArray ^= num;
        }

        return xorAll ^ xorArray;
    }
}
