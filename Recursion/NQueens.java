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
        return result;
    }

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
