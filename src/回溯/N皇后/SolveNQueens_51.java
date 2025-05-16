package 回溯.N皇后;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, ans);
        return ans;
    }

    private void backtrack(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                path.add(new String(board[i]));
            }
            ans.add(path);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (!isValid(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrack(board, row + 1, ans);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens_51 solution = new SolveNQueens_51();
        int n = 4;
        List<List<String>> ans = solution.solveNQueens(n);
        System.out.println(ans);
    }
}
