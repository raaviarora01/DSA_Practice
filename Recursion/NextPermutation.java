/* A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory. */

package Recursion;

public class NextPermutation {

    // Approach: The algorithm first identifies the rightmost pair of indices where the left index is smaller than the right index, which indicates the point where the order can be changed. If no such pair exists, it means the array is in descending order, and we reverse it to get the lowest order. If such a pair is found, we then look for the smallest element to the right of the left index that is greater than the element at the left index, and swap them. Finally, we reverse the subarray to the right of the left index to get the next permutation. The time complexity of this algorithm is O(n) due to the single pass to find the break point and another pass to reverse the subarray, while the space complexity is O(1) since it operates in place without using extra space.
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int break_pt = -1;
        for(int i=n-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                break_pt = i-1;
                break;
            }
        }

        if(break_pt == -1){
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1; i>break_pt; i--){
            if(nums[i] > nums[break_pt]){
                int temp = nums[break_pt];
                nums[break_pt] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverse(nums, break_pt+1, n-1);
    }

    public static void reverse(int[] arr, int left,  int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
