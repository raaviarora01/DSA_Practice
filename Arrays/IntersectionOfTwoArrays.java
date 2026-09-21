/* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order. */

package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    
    // Brute Force Approach: Iterate through the first array and check if each element exists in the second array. If it does, add it to a set to ensure uniqueness.
    // Time Complexity: O(n log n + m log m)
    // Space Complexity: O(k) - The method uses a HashSet to store the unique elements of the intersection, where k is the number of unique elements in the intersection.
    // Complete Analysis breakdown:
    /*
    Let n and m be the sizes of the two arrays and k be the number of unique elements in their intersection. Sorting takes O(n log n + m log m). 
    The two-pointer traversal takes O(n + m) because each pointer moves only forward. HashSet.add() is O(1) on average, and converting the k elements of the set into an int[] takes O(k).
    Therefore, the overall time complexity is O(n log n + m log m). The HashSet stores at most k elements, so the main auxiliary space is O(k).
    */
    /*
    Let n and m be the lengths of nums1 and nums2, and k be the number of unique elements in their intersection. Sorting the two arrays takes O(n log n + m log m) time.
    The two-pointer traversal takes O(n + m) time, since each pointer moves only forward. HashSet insertion takes O(1) on average, and converting the k elements of the set to an int[] takes O(k).
    Therefore, the overall time complexity is O(n log n + m log m).
    The HashSet requires O(k) extra space, local variables require O(1), and sorting may use logarithmic stack/internal space.
    Therefore, auxiliary space can be stated more precisely as O(k + log n + log m), though it is commonly reported as O(k) in standard DSA analysis.
    The returned array requires O(k) output space. If the original input arrays are also counted, the total space complexity is O(n + m).
    */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        int i=0, j=0;

        while(i < n && j < m){
            if(nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}
