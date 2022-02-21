/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {

        backtracking(board, 0, 0);

    }

    private boolean backtracking(char[][] board,  int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9)
                return true;
        }
        if (board[row][col] != '.')
            return backtracking(board, row, col + 1);
        for (int num = 1; num <= 9; num++) {
            if (isValid(num, board, row, col)) {
                board[row][col] = (char) (num + '0');
                if (backtracking(board, row, col + 1))
                    return true;

                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isValid(int num, char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            // 看所在行是否存在
            if (board[i][col] == num + '0') {
                return false;
            }
            // 看所在列是否存在
            if (board[row][i] == num + '0')
                return false;
        }
        // 看在哪个3x3宫格
        int hang = row / 3;
        int lie = col / 3;
        for (int i = hang * 3; i < hang * 3 + 3; i++) {
            for (int j = lie * 3; j < lie * 3 + 3; j++) {
                if (board[i][j] == num + '0')
                    return false;
            }
        }

        return true;
    }
}
// @lc code=end
