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
        int col = 0;
        boolean flag_col = false;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target && matrix[mid + 1][0] > target) {
                col = mid;
                flag_col = true;
                break;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            }else if(matrix[mid][0]<target&&matrix[mid+1][0]<target){
                
            }
        }
        return false;
    }
}
// @lc code=end
