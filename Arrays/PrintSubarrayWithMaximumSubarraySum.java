package Arrays;

public class PrintSubarrayWithMaximumSubarraySum {

    // Print the subarray with the largest sum using Kadane's Algorithm. Use a variable to keep track of the current subarray sum and update the maximum sum accordingly. Also, keep track of the start and end indices of the subarray while calculating the maximum sum.
    // Time Complexity: O(n), Space Complexity: O(1)
    public int printSubarrayWithMaximumSubarraySum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0, start = 0, resStart = -1, resEnd = -1;
        for(int i=0; i<nums.length; i++){
            if(sum == 0){
                start = i;
                }
 
            sum = sum + nums[i];
 
            if(sum > max){
                max = sum;
                resStart = start;
                resEnd = i;
            }
 
            if(sum < 0){
                sum = 0;
            }
        }
 
        System.out.print("The subarray is: [ ");
        for(int i = resStart; i<=resEnd; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.print("]");
 
        return max;
    }
}
