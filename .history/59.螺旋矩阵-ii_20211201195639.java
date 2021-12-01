import javax.print.attribute.standard.Media;

/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
        int k = 1;
        for (int i = 0; i <= n / 2; i++) {

            for (int j = i; j < n - i; j++) {
                matrix[i][j] = k;
                k++;
            }
            if ((k-1) == n * n && i==n/2)
                break;
            // matrix[j][n-i-1]
            for (int j = i + 1; j < n - i - 1; j++) {
                matrix[j][n - i - 1] = k;
                k++;
            }
            for (int j = n - i - 1; j >= i; j--) {
                matrix[n - i - 1][j] = k;
                k++;
            }
            for (int j = n - i - 2; j > i; j--) {
                matrix[j][i] = k;
                k++;
            }
        }
        return matrix;
    }
}
// @lc code=end
