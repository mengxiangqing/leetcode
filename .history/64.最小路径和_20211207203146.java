/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        if (m == 1 && n == 1)
            return grid[0][0];
        if (m == 1 && n != 1) {
            for (int i = 0; i < n; i++) {
                sum += grid[0][i];
            }
            return sum;
        } else if (n == 1 && m != 1) {
            for (int i = 0; i < m; i++) {
                sum += grid[i][0];
            }
            return sum;
        } else {
            int[][] path = new int[m][n];
            path[0][0] = grid[0][0];
            for (int i = 0; i < m; i++) {
                path[i][0] = path[i - 1][0] + grid[i][0];
            }
            for (int i = 0; i < n; i++) {
                path[0][i] = path[0][i-1] + grid[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    path[i][j] = Math.min(path[i][j - 1], path[i - 1][j])+grid[i][j];

                }
            }
            return path[m-1][n-1];
        }
    }
}
// @lc code=end
