/* You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 
You should return the array of nums such that the array follows the given conditions:
 
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions. */

package Arrays;

public class RearrangeArrayElementsBySign {
    
    // Create a new array and fill it with positive and negative elements in the required order.
    // Time Complexity: O(n), Space Complexity: O(n)
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int pos = 0, neg = 1;
 
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result[pos] = nums[i];
                pos += 2;
            } else{
                result[neg] = nums[i];
                neg += 2;
            }
        }
 
        return result;
    }
}
