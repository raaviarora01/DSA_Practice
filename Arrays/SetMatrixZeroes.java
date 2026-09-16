/* Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place. */

package Arrays;

public class SetMatrixZeroes {
    
    // Brute Force Approach: For each element in the matrix, if it is 0, then set its entire row and column to 0's.
    // Time Complexity: O(m * n * (m+n)) where m is the number of rows and n is the number of columns in the given matrix. For each element, we are checking all elements in its row and column.
    // Space Complexity: O(1) as we are not using any extra space.
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    for(int col=0; col<n; col++){
                        if(matrix[i][col] != 0){
                            matrix[i][col] = Integer.MIN_VALUE;
                        }
                    }

                    for(int row=0; row<m; row++){
                        if(matrix[row][j] != 0){
                            matrix[row][j] = Integer.MIN_VALUE;
                        }
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == Integer.MIN_VALUE){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Better Approach: Use two arrays to keep track of the rows and columns that need to be set to 0's.
    // Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the given matrix. We are traversing the matrix twice, once to find the rows and columns that need to be set to 0's and once to set them.
    // Space Complexity: O(m + n) where m is the number of rows and n is the number of columns in the given matrix. We are using two arrays to keep track of the rows and columns that need to be set to 0's.
    public void setZeroesBetter(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows[i] || cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
