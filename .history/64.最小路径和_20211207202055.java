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
        if (m == 1&&n == 1)
            return grid[0][0];
        if (m == 1&&n!=1) {
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
            int[] path = new int[m*n];
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    
                    
                }
            }
        }
        return sum;
    }
}
// @lc code=end

