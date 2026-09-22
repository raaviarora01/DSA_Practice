/* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input. */

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
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

    // Better Approach: Sort the intervals based on the start and then iterate through the sorted intervals. If the current interval overlaps with the previous interval, merge them. Otherwise, add the current interval to the result list.
    // Time Complexity: O(nlogn) - The method sorts the input array, which takes O(nlogn) time, and then iterates over the sorted array once.
    // Space Complexity: O(n) - The method uses a list to store the merged intervals
    public int[][] mergeBetterApproach(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        for(int[] interval : intervals){
            if(list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]){
                list.add(interval);
            } else {
                list.get(list.size() - 1)[1] = Math.max(
                    list.get(list.size() - 1)[1], interval[1]
                    );
            }
            
        }

        return list.toArray(new int[list.size()][]);
    }

    // Optimal Approach: Sort the intervals based on the start and then iterate through the sorted intervals. If the current interval overlaps with the previous interval, merge them. Otherwise, add the current interval to the result list. This approach avoids using extra space for a list and instead modifies the input array in place.
    // Time Complexity: O(nlogn) - The method sorts the input array, which takes O(nlogn) time, and then iterates over the sorted array once.
    // Space Complexity: O(1) - The method uses a constant amount of space for variables to store the merged intervals, o(n) because Arrays.copyOf is used to create a new array for the result, but this is required by the question.
    public int[][] mergeOptimalApproach(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int write = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= intervals[write][1]){
                intervals[write][1] = Math.max(intervals[write][1], intervals[i][1]);
            } else{
                write++;
                intervals[write] = intervals[i];
            }
            
        }

        return Arrays.copyOf(intervals, write + 1);
    }
}
