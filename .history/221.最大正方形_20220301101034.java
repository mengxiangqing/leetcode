/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        // dp[i][j]表示以matrix[i][j]为右下角且只包含1的正方形的边长最大值。
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0)
                        // i，j有一个是0则最大边长只能是1;
                        dp[i][j] = 1;
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                    max = Math.max(dp[i][j], max);

                }
            }
        }
        return max * max;

    }
}
// @lc code=end
