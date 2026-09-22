/* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation. */

package Arrays;

public class ProductOfArrayExceptSelf {
    
    // Brute Force Approach: Iterate through the array and for each element, calculate the product of all other elements.
    // Time Complexity: O(n^2) - The method iterates over input array twice
    // Space Complexity: O(n) - The method uses an additional array to store the result
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=0; j<nums.length; j++){
                if(!(j == i)){
                    product = product * nums[j];
                }
            }

            products[i] = product;
        }

        return products;
    }
}
