/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {

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
        //看在哪个3x3宫格
        

        return true;
    }
}
// @lc code=end
