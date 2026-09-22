/* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input. */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    
    // Brute Force Approach: Iterate through the array and for each interval, check if it overlaps with any other interval. If it does, merge them and continue checking until no more overlaps are found.
    // Time Complexity: O(n^2) - The method iterates over input array twice, but it can go up to O(n^3) in the worst case if all intervals overlap and need to be merged multiple times.
    // Space Complexity: O(n) - The method uses a list to store the merged intervals
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        for(int[] interval : intervals){
            list.add(interval);
        }

        boolean merged = true;
        while(merged){
            merged = false;

            for(int i=0; i<list.size(); i++){
                for(int j=i+1; j<list.size(); j++){
                    int[] a = list.get(i);
                    int[] b = list.get(j);

                    if(a[0] <= b[1] && b[0] <= a[1]){
                        a[0] = Math.min(a[0], b[0]);
                        a[1] = Math.max(a[1], b[1]);

                        list.remove(j);
                        merged = true;
                        break;
                    }
                }

                if(merged){
                    break;
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
