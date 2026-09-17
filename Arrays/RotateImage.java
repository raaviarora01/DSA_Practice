/* You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. */

package Arrays;

public class RotateImage {
    
    // Brute Force Approach: Create a new matrix and copy the elements from the original matrix to the new matrix in the rotated position. Then copy the new matrix back to the original matrix.
    // Time Complexity: O(n^2) where n is the number of rows (or columns) in the given matrix. We are traversing the matrix twice, once to copy the elements to the new matrix and once to copy them back to the original matrix.
    // Space Complexity: O(n^2) where n is the number of rows (or columns)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int result[][] = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                result[j][n-i-1] = matrix[i][j];
            }
        }

        for(int i=0; i<n; i++){
            matrix[i] = result[i].clone();
        }
    }
}
