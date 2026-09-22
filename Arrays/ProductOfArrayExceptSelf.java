/* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation. */

package Arrays;

public class ProductOfArrayExceptSelf {
    
    // Brute Force Approach: Iterate through the array and for each element, calculate the product of all other elements.
    // Time Complexity: O(n^2) - The method iterates over input array twice
    // Space Complexity: O(n) - The method uses an additional array to store the result, o(1) because output array is required by question
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=0; j<nums.length; j++){
                if(i != j){
                    product = product * nums[j];
                }
            }

            products[i] = product;
        }

        return products;
    }

    // Better Approach: Use two arrays to store the prefix and suffix products. The prefix product at index i is the product of all elements before index i, and the suffix product at index i is the product of all elements after index i. The final result for each index is the product of the prefix and suffix products.
    // Time Complexity: O(n) - The method iterates over input array three times.
    // Space Complexity: O(n) - The method uses two additional arrays to store the prefix and suffix products.
    public int[] productExceptSelfBetterApproach(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i=n-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i=0; i<n; i++){
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }

    // Optimal Approach: Use output array to store the prefix products and a variable to keep track of the suffix product. The prefix product at index i is the product of all elements before index i, and the suffix product is updated as we iterate from the end of the array to the beginning. The final result for each index is the product of the prefix and suffix products.
    // Time Complexity: O(n) - The method iterates over input array twice.
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the prefix and suffix products, o(1) because output array is required by question
    public int[] productExceptSelfOptimalApproach(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for(int i=1; i<n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int suffix=1;
        for(int i=n-1; i>=0; i--){
            ans[i] = ans[i] * suffix;
            suffix = suffix * nums[i];
        }

        return ans;
    }
}
