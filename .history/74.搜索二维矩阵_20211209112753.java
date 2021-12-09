/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 先判断在哪一行
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m - 1;
        while (low < high) {
            int mid = (low + high) / 2;
        }
        return false;
    }
}
// @lc code=end
