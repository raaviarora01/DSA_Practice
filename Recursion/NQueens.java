/* The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        solve(0, board, result);

        List<List<String>> result2 = new ArrayList<>();
        int leftRow[] = new int[n];
        int lowerDiagnol[] = new int[2*n - 1];
        int upperDiagnol[] = new int[2*n - 1];
        solve2(0, board, result2, leftRow, lowerDiagnol, upperDiagnol);

        return result;
    }

    // Approach 1: Using backtracking to explore all possible placements of queens on the board, checking for conflicts with previously placed queens. The time complexity is O(n!) in the worst case, as there are n choices for the first queen, n-1 for the second, and so on. The space complexity is O(n) for the recursive call stack and O(n^2) for the board representation.
    public static void solve(int col, char[][] board, List<List<String>> result){
        if(col == board.length){
            result.add(construct(board));
            return;
        }

        for(int row=0; row<board.length; row++){
            if(validate(row, col, board)){
                board[row][col] = 'Q';
                solve(col + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    // Approach 2: Using additional arrays to keep track of the rows and diagonals that are already occupied by queens, which allows for O(1) time complexity for checking if a queen can be placed in a given position. The space complexity is O(n) for the leftRow array and O(2*n - 1) for the lowerDiagnol and upperDiagnol arrays, resulting in O(n) space complexity overall.
    public static void solve2(int col, char[][] board, List<List<String>> result, int leftRow[], int lowerDiagnol[], int upperDiagnol[]){
        if(col == board.length){
            result.add(construct(board));
            return;
        }

        for(int row=0; row<board.length; row++){
            if(leftRow[row] == 0 && lowerDiagnol[row + col] == 0 && upperDiagnol[(board.length - 1) + (col - row)] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagnol[row + col] = 1;
                upperDiagnol[(board.length - 1) + (col - row)] = 1;
                solve2(col + 1, board, result, leftRow, lowerDiagnol, upperDiagnol);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagnol[row + col] = 0;
                upperDiagnol[(board.length - 1) + (col - row)] = 0;
            }
        }
    }

    public static boolean validate(int row, int col, char[][] board){
        int dupRow = row;
        int dupCol = col;

        while(dupRow >= 0 && dupCol >= 0){
            if(board[dupRow][dupCol] == 'Q') return false;
            dupRow--;
            dupCol--;
        }

        dupRow = row;
        dupCol = col;
        while(dupCol >= 0){
            if(board[dupRow][dupCol] == 'Q') return false;
            dupCol--;
        }

        dupRow = row;
        dupCol = col;
        while(dupRow < board.length && dupCol >= 0){
            if(board[dupRow][dupCol] == 'Q') return false;
            dupRow++;
            dupCol--;
        }

        return true;
    }

    public static List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);
            list.add(s);
        }

        return list;
    }
}
