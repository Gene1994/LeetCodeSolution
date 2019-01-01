//package backtracking;
//
///**
// * @author: create by Gene1994
// * @date:2018/12/22
// */
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * No.51 N-Queens
// *
// * Difficulty:Difficult
// *
// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// Example:
//
// Input: 4
// Output: [
// [".Q..",  // Solution 1
// "...Q",
// "Q...",
// "..Q."],
//
// ["..Q.",  // Solution 2
// "Q...",
// "...Q",
// ".Q.."]
// ]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
// */
//public class NQueens {
//    public List<List<String>> solveNQueens(int n) {
//        char[][] board = new char[n][n];
//        for(int i = 0; i < n; i++)
//            for(int j = 0; j < n; j++)
//                board[i][j] = '.';
//        List<List<String>> res = new ArrayList<>();
//        dfs(board,0, res);
//
//    }
//
//    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
//        if (colIndex == board.length)
//
//            return;
//        for (int i = 0; i < board.length; i++) {
//            if (valid(board, i, colIndex)) {
//                board[i][colIndex] = 'Q';
//                dfs(board, i+1, res);
//                board[i][colIndex] = '.';
//
//            }
//        }
//    }
//
//    private boolean valid(char[][] board, int i, int j) {
//
//    }
//}
