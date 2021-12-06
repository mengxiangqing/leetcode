/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            path[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                }
                if (i > 0)
                    path[i][j] += path[i - 1][j];
                if (j > 0)
                    path[i][j] += path[i][j - 1];
            }
        }
        // int obs = 0;
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (obstacleGrid[i][j] == 1) {
        // obs += path[i][j];
        // }
        // }
        // }
        return path[m - 1][n - 1];
    }
}
// @lc code=end
