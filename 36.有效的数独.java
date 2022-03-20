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
                    int index = board[i][j] - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    gong[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || gong[i / 3][j / 3][index] > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
