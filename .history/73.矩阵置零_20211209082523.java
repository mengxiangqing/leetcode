/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    //用第一行，第一列作为记录数组，若
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag_col = false;    
        boolean flag_row = false;    
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag_col = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                flag_row = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //判断第一行列是否有0,若有则全为零
        if (flag_col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if(flag_row)
        {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        
    }
}
// @lc code=end
