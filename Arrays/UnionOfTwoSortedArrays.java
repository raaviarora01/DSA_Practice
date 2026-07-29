/* Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.



The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both. */

package Arrays;

import java.util.Arrays;

public class UnionOfTwoSortedArrays {

    /** Optimal Approach: Uses two pointers to traverse both sorted arrays and build the union array while avoiding duplicates.
     * Time Complexity: O(n + m) - The method iterates through both input arrays once.
     * Space Complexity: O(n + m) - The method uses additional space for the result array.
     */
    public int[] unionOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                if (k == 0 || result[k - 1] != nums1[i]) {
                    result[k++] = nums1[i];
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (k == 0 || result[k - 1] != nums2[j]) {
                    result[k++] = nums2[j];
                }
                j++;
            } else {
                if (k == 0 || result[k - 1] != nums1[i]) {
                    result[k++] = nums1[i];
                }
                i++;
                j++;
            }
        }

        while (i < n) {
            if (k == 0 || result[k - 1] != nums1[i]) {
                result[k++] = nums1[i];
            }
            i++;
        }

        while (j < m) {
            if (k == 0 || result[k - 1] != nums2[j]) {
                result[k++] = nums2[j];
            }
            j++;
        }

        return Arrays.copyOf(result, k);
    }

}
