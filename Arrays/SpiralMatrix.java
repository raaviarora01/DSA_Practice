/* Given an m x n matrix, return all elements of the matrix in spiral order. */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    
    // Movement in spiral order is right, down, left, up. We can keep track of the boundaries of the matrix and move in the spiral order until we have traversed all the elements of the matrix.
    // Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the given matrix. We are traversing all the elements of the matrix once.
    // Space Complexity: O(1) as we are not using any extra space. O(m * n) for the output list.
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize boundaries for the spiral traversal
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        List<Integer> ans = new ArrayList<>();

        // Loop until the boundaries meet
        while(top <= bottom && left <= right){

            // Traverse the top row from left to right
            for(int i=left; i<=right; i++){
                ans.add(matrix[top][i]);
            }
            top++; // Move the top boundary downward

            // Traverse the right column from top to bottom
            for(int i=top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftward

            // Traverse the bottom row from right to left if there are remaining rows
            if(top <= bottom){
                for(int i=right; i>=left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top if there are remaining columns
            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }

        return ans;
    }
}
