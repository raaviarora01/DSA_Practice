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

    /* Transpose means swapping the rows and columns of a matrix. */

    // Optimal Approach 1: Transpose the matrix and then reverse each row. Transpose the lower triangle(including diagonal) of the matrix by swapping the elements at (i, j) and (j, i). Then reverse each row of the matrix by swapping the elements at (i, j) and (i, n-j-1).
    // Time Complexity: O(n^2) where n is the number of rows (or columns) in the given matrix. We are traversing the matrix twice, once to transpose it and once to reverse each row.
    // Space Complexity: O(1) as we are not using any extra space.
    public void rotateOptimalVersion1(int[][] matrix) {
        int n = matrix.length;

        // Transpose the lower triangle(including diagonal) by swapping
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row by swapping
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

    // Optimal Approach 2: Transpose the matrix and then reverse each row. Transpose the upper triangle(excluding diagonal) of the matrix by swapping the elements at (i, j) and (j, i). Then reverse each row of the matrix by swapping the elements at (i, j) and (i, n-j-1).
    // Time Complexity: O(n^2) where n is the number of rows (or columns) in the given matrix. We are traversing the matrix twice, once to transpose it and once to reverse each row.
    // Space Complexity: O(1) as we are not using any extra space.
    public void rotateOptimalVersion2(int[][] matrix) {
        int n = matrix.length;

        // Transpose the upper triangle(excluding diagonal) by swapping
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row by swapping
        for(int i=0; i<n; i++){
            int left = 0, right = n-1;

            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
