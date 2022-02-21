/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        // 统计空格个数
        int count=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]=='.')count++;
            }
        }

        backtracking(board,count);

    }

    private void backtracking(char[][] board, int count) {
        if (count == 0)
            return;
        for (int i = 1; i <= 9; i++) {
            
        }
    }

    private boolean isValid(int num, char[][] board, int line, int column) {
        for (int i = 0; i < board.length; i++) {
            // 看所在行是否存在
            if (board[i][column] == num - '0') {
                return false;
            }
            // 看所在列是否存在
            if (board[line][i] == num - '0')
                return false;
        }
        // 看在哪个3x3宫格
        int hang = line / 3;
        int lie = column / 3;
        for (int i = hang * 3; i < hang * 3 + 3; i++) {
            for (int j = lie * 3; j < lie * 3 + 3; j++) {
                if (board[i][j] == num - '0')
                    return false;
            }
        }

        return true;
    }
}
// @lc code=end
