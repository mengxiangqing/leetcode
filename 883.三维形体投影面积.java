/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */
/**
 * 883.三维形体投影面积
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        int di = 0;
        int xz = 0;
        int zy = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            int max2 = 0;
            for (int j = 0; j < grid[0].length; j++) {
                di += grid[i][j] == 0 ? 0 : 1;
                max = grid[i][j] > max ? grid[i][j] : max;
                max2 = grid[j][i] > max2 ? grid[j][i] : max2;
            }
            xz += max;
            zy += max2;
        }


        return di + xz + zy;
    }
}
// @lc code=end
