package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    // Brute Force approach: Count the frequency of each element and return the one with the highest count.
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public int majorityElementBruteForce(int[] nums) {
        int n = nums.length;
 
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(nums[j] == nums[i]) count++;
            }
 
            if(count > (n/2)) return nums[i];
        }
 
        return -1;
    }
 
    // Better approach: Use a HashMap to count the frequency of each element and return the one with the highest count.
    // Time Complexity: O(n), Space Complexity: O(n)
    public int majorityElementBetter(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
 
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > (n/2)) return entry.getKey();
        }
 
        return -1;
    }
 
    // Optimal approach: Boyer-Moore Voting Algorithm. Use a counter to keep track of the current candidate for the majority element.
    // Time Complexity: O(n), Space Complexity: O(1)
    public int majorityElementOptimal(int[] nums) {
        int ele = nums[0];
        int count = 1;
 
        for(int i=1; i<nums.length; i++){
            if(count == 0){
                ele = nums[i];
                count = 1;
            } else if(nums[i] == ele){
                count++;
            } else{
                count--;
            }
        }

        return ele;
    }
}
