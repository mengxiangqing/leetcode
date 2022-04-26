/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        int di = grid.length + grid[0].length;
        int xz = 0;
        int zy = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for(int j = 0;j<grid[0].length;j++){

                grid[i][j]>max?grid[i][j]:max;
            }
        }

        return di + xz + zy;
    }
}
// @lc code=end

