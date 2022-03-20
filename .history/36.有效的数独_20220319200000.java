/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows[][] = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] gong = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - 'a' - 1;

                }
            }
        }
        return true;
    }
}
// @lc code=end
