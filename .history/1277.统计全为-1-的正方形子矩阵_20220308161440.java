/*
 * @lc app=leetcode.cn id=1277 lang=java
 *
 * [1277] 统计全为 1 的正方形子矩阵
 */

// @lc code=start
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (j == 0 || i == 0) {
                        f[i][j] = 1;
                    }
                    else {
                        f[i][j] = Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(f[i][j], max);
                }
            }
        }
        return max;
    }
}
// @lc code=end
